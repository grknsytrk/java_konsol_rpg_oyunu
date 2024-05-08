package game;

import java.util.Scanner;

public abstract class Location {
    Scanner scan = new Scanner(System.in);
    protected Player player;
    protected String name;

    Location(Player player) {
        this.player = player;
    }

    public abstract boolean getLocation();

    public void setPlayer(Player player){
        this.player=player;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public Player getPlayer(){
        return this.player;
    }
    
    public String getName(){
        return this.name;
    }
    
}
