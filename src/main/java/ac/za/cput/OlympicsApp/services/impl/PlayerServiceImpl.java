package ac.za.cput.OlympicsApp.services.impl;

import ac.za.cput.OlympicsApp.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ac.za.cput.OlympicsApp.repository.PlayerRepository;
import ac.za.cput.OlympicsApp.services.PlayerService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lodz on 2016/08/18.
 */
@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    @Override
    public Player create(Player entity) {
        System.out.println("create");
        return playerRepository.save(entity);
    }

    @Override
    public Player readById(Long id) {
        return playerRepository.findOne(id);
    }

    @Override
    public Player update(Player entity) {
        return playerRepository.save(entity);
    }

    @Override
    public void delete(Player entity) {
        playerRepository.delete(entity);
    }

    @Override
    public Set<Player> readAll() {
        Set<Player> players = new HashSet<Player>();
        for ( Player player: playerRepository.findAll()){
            players.add(player);
        }

        return players;
    }
}
