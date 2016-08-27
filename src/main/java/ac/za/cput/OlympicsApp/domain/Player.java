package ac.za.cput.OlympicsApp.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by lodz on 2016/08/17.
 */
@Entity
public class Player implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

   // @Column(unique =true)
    private String playerName;

     //@Column(name = "PlayerName")
    private String playerSurname;

    // @Column(name = "PlayerName")
    private String playerAge;


    private Player(){}
    public Player(Builder builder)
    {

        this.id = builder.id;
        this.playerName = builder.playerName;
        this.playerSurname = builder.playerSurname;
        this.playerAge = builder.playerAge;
    }



    public long getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerAge() {
        return playerAge;
    }

    public String getPlayerSurname() {
        return playerSurname;
    }

    public static class Builder{
        private String playerName;
        private String playerSurname;
        private String playerAge;
        private long id;


        public Builder(String  playerName){
            this.playerName = playerName;
        }
        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder PlayerName(String playerName) {
            this.playerName = playerName;
            return this;
        }

        public Builder PlayerSurname(String playerSurname) {
            this.playerSurname = playerSurname;
            return this;
        }

        public Builder PlayerAge(String playerAge) {
            this.playerAge = playerAge;
            return this;
        }

        public Builder copy(Player player){
            this.id = player.id;

            this.playerName = player.playerName;
            this.playerSurname = player.playerSurname;
            this.playerAge = player.playerAge;
            return this;
        }

        public Player build()
        {
            return  new Player(this);
        }
    }

    @Override
    public boolean equals(Object o){
        if(this == o)return true;
        if(o == null ||getClass() != o.getClass()) return false;

        Player player = (Player) o;
        return id == player.id;
    }

    @Override
    public int hashCode(){
        return (int)(id ^(id >>> 32));
    }

}
