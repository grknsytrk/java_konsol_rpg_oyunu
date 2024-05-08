
package game;

import java.util.Random;


public class Monster {
    private String name;
    private int damage,healthy,award,maxNumber;

    public Monster(String name, int damage, int healthy, int award, int maxNumber) {
        this.name = name;
        this.damage = damage;
        this.healthy = healthy;
        this.award = award;
        this.maxNumber = maxNumber;
    }

    public int monsterCount(){
        Random r = new Random();
        int random = 2+r.nextInt(this.maxNumber);
        return random;
    }
    
    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public int getAward() {
        return award;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }
    
}
