package ac.za.cput.OlympicsApp.repository;

import ac.za.cput.OlympicsApp.App;
import ac.za.cput.OlympicsApp.domain.Player;
import ac.za.cput.OlympicsApp.factories.PlayerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by lodz on 2016/08/17.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = App.class)
//@WebAppConfiguration
public class PlayerRepositoryTest extends AbstractTestNGSpringContextTests{

    //Player player;
    // @Qualifier("PlayerServiceImpl")
    @Autowired
    private PlayerRepository repository;
    private Long id;
    private Map<String,String> map;
    private Map<String,String> map2;
    Player player;

   // @BeforeMethod
    public void setUp() throws Exception {
        map = new HashMap<>();
        map2 = new HashMap<>();
    }

  //  @Test
    public void testPlayerRepo() throws Exception {
        map.put("name","bongz");
        map.put("surname","Tsipa");
        map.put("age","20");
        player = repository.save(PlayerFactory.getPlayer(map));
        id = player.getId();
        Assert.assertNotNull(id);
    }

   // @Test
    public void testPlayerUpdate()throws Exception{
      // map2.get("name");

        map.put("name","Lite");
        map.put("surname","Tsipa");
        map.put("age","28");
        player = repository.save(PlayerFactory.getPlayer(map));

        map2.put("name","Zozo");
        map2.put("surname","Mjoli test");
        map2.put("age","23");


        player = repository.findOne(player.getId());

        Player updatedPlayer = PlayerFactory.getPlayer(map2);

        Player copyPlayer = new Player.Builder(player.getPlayerName())
                .copy(updatedPlayer)
                .build();

        repository.save(copyPlayer);

        Player newUpdated = repository.findOne(copyPlayer.getId());
        Assert.assertEquals("Zozo", newUpdated.getPlayerName());
       // Assert.assertNotNull(copyPlayer.getId());
    }

  //  @Test
    public void testPlayerDelete() throws Exception {
        map.put("name","Elements");
        map.put("surname","deleted");
        map.put("age","data");
        player = repository.save(PlayerFactory.getPlayer(map));
        long id;
        Player newPlayer = repository.findOne(player.getId());
      //  id = player.getId();
        repository.delete(newPlayer);

        Assert.assertNotEquals(newPlayer.getPlayerName(),"Element");
    }
}
