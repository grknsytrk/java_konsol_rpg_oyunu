
package game;

import java.util.Scanner;

public class Player {
    private int damage,healthy,money,rHealthy;
    private String name,cName; //cName =character name 
    private Inventory inv;
    Scanner scan = new Scanner(System.in);
    
    public Player(String name){
        this.name=name;
        this.inv = new Inventory();
    }
    
    public void selectCharacter(){
        switch (characterMenu()){
            case 1:
                initPlayer("Samuray",6,21,18);
                break;
            case 2:
                initPlayer("Okcu",7,18,20);
                break;
            case 3:
                initPlayer("Buyucu",8,24,5);
                break;
            default: //bug olursa oyuncu samuray olsun..
                initPlayer("Samuray",6,21,18);
                break;   
        }
        System.out.println("\nSevgili "+getName()+",\nSectigin karakter: "+getcName()+"\nHasari: "+getDamage()+"\nCani: "+getHealthy()+"\nParasi: "+getMoney());
        
    }
    
    public void initPlayer(String cName, int dmg , int hp, int money){
        setcName(cName);
        setDamage(dmg);
        setHealthy(hp);
        setMoney(money);
        setrHealthy(hp);
    }
    
    public int characterMenu(){
        System.out.println("Karakter seciniz:");
        System.out.println("1. Samuray ->  Hasari: 6   Cani: 21   Parasi: 18G");
        System.out.println("2. Okcu    ->  Hasari: 7   Cani: 18   Parasi: 20G");
        System.out.println("3. Buyucu ->  Hasari: 8   Cani: 24   Parasi: 5G");
        System.out.println("Karakter Seciniz : ");
        int characterID = scan.nextInt();
        
        while(characterID <0 || characterID > 3){
            System.out.println("Lutfen gecerli bir secim yapiniz.");
            System.out.println("Karakter Seciniz : ");
            characterID = scan.nextInt();   
        }
        
        return characterID;
    }
    public int getDamage(){
        return this.damage;
    }
    
    public int getHealthy(){
        return this.healthy;
    }
    
    public int getMoney(){
        return this.money;
    }
    
    public String getcName(){
        return this.cName;
    }
    
    public int getrHealthy(){
        return this.rHealthy;
    }

    public String getName() {
        return name;
    }

    public Inventory getInv() {
        return inv;
    }
    
    public int getTotalDamage(){
        return this.damage+this.getInv().getDamage();
    }
    
    public void setDamage(int damage){
        this.damage=damage;
    }
   
    public void setHealthy(int healthy){
        this.healthy=healthy;
    }
    
    public void setMoney(int money){
        this.money=money;
    }
    
    public void setcName(String cName){
        this.cName=cName;
    }
    
    public void setrHealthy(int rHealthy){
        this.rHealthy=rHealthy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }
    
}
