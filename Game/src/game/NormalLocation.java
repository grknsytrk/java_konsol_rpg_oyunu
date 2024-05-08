
package game;

import java.util.Scanner;

public abstract class NormalLocation extends Location{
    Scanner scan = new Scanner(System.in);
    NormalLocation(Player player,String name) {
        super(player);
        this.name=name;
    }
    
    @Override
    public boolean getLocation(){
        return true;
    }

    
}
