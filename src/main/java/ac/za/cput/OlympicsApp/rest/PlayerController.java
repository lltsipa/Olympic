package ac.za.cput.OlympicsApp.rest;

import ac.za.cput.OlympicsApp.domain.Player;
import ac.za.cput.OlympicsApp.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

/**
 * Created by lodz on 2016/08/16.
 */
@RestController
@RequestMapping(value = "/**")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    //Read all players
    @RequestMapping(value = "/players", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<Player>> getAllPlayers(){
        Set<Player> player = playerService.readAll();
        if(player.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(player,HttpStatus.OK);
    }

    //Creating a player
    @RequestMapping(value = "/player/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createPlayer(@RequestBody Player player, UriComponentsBuilder uBuilder){
        playerService.create(player);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uBuilder.path("/player/{id}").buildAndExpand(player.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //Update Player
    @RequestMapping(value = "/player/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Player> updatePlayer(@PathVariable("id") long id, @RequestBody Player player){
        Player currentPlayer = playerService.readById(id);

        if(currentPlayer == null) {
            return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
        }

        Player updatePlayer = new Player.Builder(currentPlayer.getPlayerName()).copy(currentPlayer)
                .PlayerName(player.getPlayerName())
                .PlayerSurname(player.getPlayerSurname())
                .PlayerAge(player.getPlayerAge())
                .build();
        playerService.update(updatePlayer);

        return new ResponseEntity<Player>(updatePlayer, HttpStatus.OK);
    }

    //Delete a player
    @RequestMapping(value = "/player/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Player> deletePlayer(@PathVariable("id") long id) {
        Player player = playerService.readById(id);

        if(player == null) {
            return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
        }

        playerService.delete(player);

        return new ResponseEntity<Player>(HttpStatus.NO_CONTENT);
    }




    //Read player by id
    @RequestMapping(value = "/player/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Player> getPlayer(@PathVariable("id") long id){
        Player player = playerService.readById(id);

        if(player == null){
            return  new ResponseEntity<Player>(HttpStatus.CREATED);
        }
        return  new ResponseEntity<Player>(HttpStatus.OK);
    }
}
