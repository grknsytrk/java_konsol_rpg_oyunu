
package game;



public class Store extends NormalLocation{
    
    public Store(Player player) {
        super(player, "Magaza");
    }
    @Override
    public boolean getLocation(){
        System.out.println("Paraniz: "+player.getMoney());
        System.out.println("1. Silahlar");
        System.out.println("2. Zirhlar");
        System.out.println("3. Cikis");
        System.out.println("Seciminiz: ");
        int selectTool = scan.nextInt();
        int selectItemID;
        switch(selectTool){
            case 1:
                selectItemID = weaponMenu();
                buyWeapon(selectItemID);
                break;
            case 2:
                selectItemID = armorMenu();
                buyArmor(selectItemID);
                break;
            case 3:
                System.out.println("Cikis yapiliyor...");
                break;
            default:
                
                break;
        }
        return true;
    }
    
    public int armorMenu(){
        System.out.println("1. Hafif -> Koruma: 1  Para: 15");
        System.out.println("2. Normal -> Koruma: 2  Para: 30");
        System.out.println("3. Agir -> Koruma: 3  Para: 50");
        System.out.println("4. Cikis");
        System.out.println("Seciminiz: ");
        int selectArmorID =scan.nextInt();
        return selectArmorID;
    }
    
    public void buyArmor(int itemID){
        int avoid = 0,price = 0;
        String armorName=null;
        
        switch(itemID){
            case 1:
                avoid=1;
                price=15;
                armorName="Hafif Zirh";
                break;
            case 2:
                avoid=2;
                price=30;
                armorName="Normal Zirh";
                break;
            case 3:
                avoid=3;
                price=50;
                armorName="Agir Zirh";
                break;
            case 4:
                System.out.println("Cikis yapiliyor...");
                break;
            default:
                System.out.println("Gecersiz islem.");
                break;
                
        }
        
        if(itemID>0 && itemID<4){
            if(player.getMoney() > price){
                player.getInv().setArmor(avoid);
                player.getInv().setArmorName(armorName);
                player.setMoney(player.getMoney()-price);
                System.out.println(armorName+" satin aldiniz. Korumaniz: "+player.getInv().getArmor());
                System.out.println("Kalan paraniz: "+player.getMoney());
                }
            else{
                System.out.println("Paraniz yetersiz.");
            }
        }
    }
    
    public int weaponMenu(){
        if(player.getcName().equals("Samuray")){
            System.out.println("1. Bokken -> Hasar: 3  Para: 30G");
            System.out.println("2. Katana -> Hasar: 6  Para: 65G");
            System.out.println("3. BANKAI -> Hasar: 15  Para: 125G");
            System.out.println("4. Cikis");
            System.out.println("Seciminiz: ");
            int selectWeaponID =scan.nextInt();
            return selectWeaponID;
        }
        if(player.getcName().equals("Okcu")){
            System.out.println("1. Demir Yay -> Hasar: 4  Para: 40G");
            System.out.println("2. Celik Yay -> Hasar: 6  Para: 55G");
            System.out.println("3. Arbalet -> Hasar: 9  Para: 90G");
            System.out.println("4. Cikis");
            System.out.println("Seciminiz: ");
            int selectWeaponID =scan.nextInt();
            return selectWeaponID;
        }
        if(player.getcName().equals("Buyucu")){
            System.out.println("1. Yanan Cubuk -> Hasar: 2  Para: 35G");
            System.out.println("2. Buz Eldiveni -> Hasar: 5  Para: 60G");
            System.out.println("3. Hayati Asa -> Hasar: 10  Para: 100G");
            System.out.println("4. Cikis");
            System.out.println("Seciminiz: ");
            int selectWeaponID =scan.nextInt();
            return selectWeaponID;
        }
        return 1;
        
    }
    
    public void buyWeapon(int itemID){
        int damage = 0,price = 0;
        String weaponName=null;
        if(player.getcName().equals("Samuray")){
            switch(itemID){
            case 1:
                damage=3;
                price=30;
                weaponName="Bokken";
                break;
            case 2:
                damage=6;
                price=65;
                weaponName="Katana";
                break;
            case 3:
                damage=15;
                price=125;
                weaponName="BANKAI";
                break;
            case 4:
                System.out.println("Cikis yapiliyor...");
                break;
            default:
                System.out.println("Gecersiz islem.");
                break;
                
            }
        }
        
        if(player.getcName().equals("Okcu")){
           switch(itemID){
            case 1:
                damage=4;
                price=40;
                weaponName="Demir Yay";
                break;
            case 2:
                damage=6;
                price=55;
                weaponName="Celik Yay";
                break;
            case 3:
                damage=9;
                price=90;
                weaponName="Arbalet";
                break;
            case 4:
                System.out.println("Cikis yapiliyor...");
                break;
            default:
                System.out.println("Gecersiz islem.");
                break;
                
            } 
        }
       
        if(player.getcName().equals("Buyucu")){
            switch(itemID){
            case 1:
                damage=2;
                price=35;
                weaponName="Yanan Cubuk";
                break;
            case 2:
                damage=5;
                price=60;
                weaponName="Buz Eldiveni";
                break;
            case 3:
                damage=10;
                price=100;
                weaponName="Hayati Asa";
                break;
            case 4:
                System.out.println("Cikis yapiliyor...");
                break;
            default:
                System.out.println("Gecersiz islem.");
                break;
                
            }  
        }
        
        if(itemID>0 && itemID<4){
            if(player.getMoney() >= price){
                player.getInv().setDamage(damage);
                player.getInv().setWeaponName(weaponName);
                player.setMoney(player.getMoney()-price);
                System.out.println(weaponName+" satin aldiniz. Onceki hasariniz: "+player.getDamage()+" Yeni Hasariniz: "+player.getTotalDamage());
                System.out.println("Kalan paraniz: "+player.getMoney());
                }
            else{
                System.out.println("Paraniz yetersiz.");
            }
        }
    }
    
    
}
