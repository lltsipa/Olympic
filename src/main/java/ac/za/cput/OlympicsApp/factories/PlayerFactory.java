package ac.za.cput.OlympicsApp.factories;

import ac.za.cput.OlympicsApp.domain.Player;

import java.util.Map;

/**
 * Created by lodz on 2016/08/17.
 */
public class PlayerFactory {

    public static Player getPlayer(Map<String,String>  stringStringMap ){
        Player  player = new Player.Builder(stringStringMap.get("name"))
                .PlayerName(stringStringMap.get("name"))
                .PlayerSurname(stringStringMap.get("surname"))
                .PlayerAge(stringStringMap.get("age"))
                .build();

        return player;
    }
}
