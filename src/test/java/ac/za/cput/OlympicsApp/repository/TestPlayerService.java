package ac.za.cput.OlympicsApp.repository;

import ac.za.cput.OlympicsApp.App;
import ac.za.cput.OlympicsApp.domain.Player;
import ac.za.cput.OlympicsApp.factories.PlayerFactory;
import ac.za.cput.OlympicsApp.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lonwabo on 8/19/2016.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestPlayerService extends AbstractTestNGSpringContextTests {

    @Autowired
    private PlayerService service;
    private Map<String,String> map;

    @BeforeMethod
    public void setUp() throws Exception {
        map = new HashMap<>();
    }

    @Test
    public void testPlayerService() throws Exception {
        map.put("name","Lonwabo 2");
        map.put("surname","Tsipa");
        map.put("age","20");
        Player player =  service.create(PlayerFactory.getPlayer(map));
        Assert.assertEquals(player.getPlayerName(),"Lonwabo");
    }
}
