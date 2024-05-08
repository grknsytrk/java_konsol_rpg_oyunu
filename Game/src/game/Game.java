
package game;

import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scan = new Scanner(System.in);
    
    public void login(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Oyuna hos geldin !");
        System.out.println("Oyuncunun ismini girin:");
        String playerName = sc.nextLine();
        player = new Player(playerName);
        player.selectCharacter();
        start();
    }
    
    public void start(){
        while(true){
            System.out.println();
        System.out.println("-------------------------------------------------------------");
        System.out.println();
        System.out.println("Harekete gecmek icin bir yer seciniz: ");
        System.out.println("1. Guvenli Ev -> Tamamen sana ait dusmanlardan arindirilmis bir ev !");
        System.out.println("2. Magara     -> Zombilerin mekanidir girerken savasa hazir ol ! ");
        System.out.println("3. Orman      -> Vampirler agaclarin golgesinde cok sık gezer dikkatli ol !");
        System.out.println("4. Nehir      -> Besine ihtiyaci olan ayilar burada gezer. Karsina cikabilirler !");
        System.out.println("5. Magaza     -> Silah veya zirh satin alabilecegin mekan.");
        System.out.println("Gitmek istediginiz yeri seciniz: ");
        
        int selectLocation = scan.nextInt();
        
        while(selectLocation <0 || selectLocation>5){
            System.out.println("Lutfen gecerli bir yer seciniz !");
            System.out.println("Gitmek istediginiz yeri seciniz: ");
            selectLocation = scan.nextInt();

        }
        switch(selectLocation){
            case 1:
                location = new SafeHouse(player);   
                break;
            case 2:
                location = new Cave(player);
                break;
            case 3:
                location = new Forest(player);
                break;
            case 4:
                location = new River(player);
                break;
            case 5:
                location = new Store(player);
                break;
            default :
                location = new SafeHouse(player);
                break;
        }
        if(location.getName() == "Guvenli Ev"){
            if(player.getInv().isFirewood() == true && player.getInv().isFood() == true && player.getInv().isWater() == true){
                System.out.println("\nTebrikler , oyunu kazandiniz !");
                System.exit(0);
                
            }
        }
        if(!location.getLocation()){
            System.out.println("Oyun bitti.");
            break;
        }
        }
    }

            
    
}
