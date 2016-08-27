package ac.za.cput.OlympicsApp.repository;

import ac.za.cput.OlympicsApp.domain.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lodz on 2016/08/17.
 */
@Repository
public interface PlayerRepository extends CrudRepository<Player,Long> {

}
