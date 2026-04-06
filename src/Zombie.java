public class Zombie {
    private int health;

    public Zombie() {
        this.health = 30;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    public int attack() {
        return 5 + (int) (Math.random() * 10); // random damage 5-14
    }
}