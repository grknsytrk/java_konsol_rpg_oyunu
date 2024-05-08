
package game;

public class SafeHouse extends NormalLocation{
    
    public SafeHouse(Player player) {
        super(player,"Guvenli Ev");
    }
    
    @Override
    public boolean getLocation(){
        player.setHealthy(player.getrHealthy());
        System.out.println("Su an evindesin ve eve dondugun icin canin doldu !");
        return true;
    }
    
}
