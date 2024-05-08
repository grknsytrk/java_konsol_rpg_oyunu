
package game;

public abstract class BattleLocation extends Location{
    protected Monster monster;
    protected String award;
    
    BattleLocation(Player player, String name, Monster monster, String award) {
        super(player);
        this.name=name;
        this.monster=monster;
        this.award=award;
    }
    
    @Override
    public boolean getLocation(){
        int monsterCount = monster.monsterCount();
        System.out.println("Suan buradasiniz -> "+this.getName());
        System.out.println("Dikkatli ol ! Burada "+monsterCount+" tane "+monster.getName()+" var !");
        System.out.println("Savas veya Kac <S/K> !");
        String selectCase = scan.nextLine();
        selectCase = selectCase.toUpperCase();
        if(selectCase.equals("S")){
            if(combat(monsterCount) == true){
                System.out.println("\nTebrikler, "+this.getName()+" bolgesindeki tum dusmanlari oldurdunuz !");
                if(this.award.equals("Elmas") && player.getInv().isFood() == false){
                    System.out.println(this.award+ " Kazandiniz !");
                    player.getInv().setFood(true);
                }
                else if(this.award.equals("Vampir Disi") && player.getInv().isWater() == false){
                    System.out.println(this.award+ " Kazandiniz !");
                    player.getInv().setWater(true);
                }
                else if(this.award.equals("Hazine") && player.getInv().isFirewood() == false){
                    System.out.println(this.award+ " Kazandiniz !");
                    player.getInv().setFirewood(true);
                }
                return true;
            }
            if(player.getHealthy() <= 0){
                System.out.println("\nOldunuz !");
                return false;
            }
        }
        
        return true;
    }
    
    public boolean combat(int monsterCount){
        for(int i = 0; i<monsterCount; i++){
            int defaultMonsterHP = monster.getHealthy();
            playerStats();
            enemyStats();
            while(player.getHealthy() >0 && monster.getHealthy() >0){
                System.out.println("Vur veya Kac <V/K> !");
                String selectCase = scan.nextLine();
                selectCase = selectCase.toUpperCase();
                if(selectCase.equals("V")){
                    System.out.println("Hasar verdiniz !");
                    monster.setHealthy(monster.getHealthy()-player.getTotalDamage());
                    afterHit();
                    if(monster.getHealthy() > 0){
                        System.out.println();
                        System.out.println(monster.getName()+" size vurdu !");
                        player.setHealthy(player.getHealthy()-(monster.getDamage()-player.getInv().getArmor()));
                        afterHit();
                    }
                }
                else{
                    return false;
                }
                
            }
            
            if(monster.getHealthy() <=0 && player.getHealthy() > 0){
                player.setMoney(player.getMoney()+monster.getAward());
                System.out.println("Guncel paraniz: "+player.getMoney()+"G");
                monster.setHealthy(defaultMonsterHP);
            }
            else{
                return false;
            }
        }  
        return true;
    }
    
    public void playerStats(){
        System.out.println("\nStatsiniz:\n----------------------");
        System.out.println("Caniniz: "+player.getHealthy());
        System.out.println("Hasariniz: "+player.getTotalDamage());
        System.out.println("Paraniz: "+player.getMoney()+"G");
        if(player.getInv().getDamage() > 0 ){
            System.out.println("Silahiniz: "+player.getInv().getWeaponName());
        }
        if(player.getInv().getArmor() > 0){
            System.out.println("Zirhiniz: "+player.getInv().getArmorName());
        }
    }
    
    public void enemyStats(){
        System.out.println("\n"+monster.getName()+" statsi:\n----------------------");
        System.out.println("Cani: "+monster.getHealthy());
        System.out.println("Hasari: "+monster.getDamage());
        System.out.println("Kelle odulu: "+monster.getAward()+"G");
        
    }
    
    public void afterHit(){
        System.out.println("Caniniz: "+player.getHealthy());
        System.out.println(monster.getName()+" cani: "+monster.getHealthy());
    }
    
    
}
