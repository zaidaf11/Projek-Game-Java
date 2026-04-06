import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int health;
    private int level;
    private int exp;
    private List<String> inventory;

    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.level = 1;
        this.exp = 0;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public List<String> getInventory() {
        return inventory;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    public int attack() {
        return 10 + (level * 2); // damage increases with level
    }

    public void gainExp(int exp) {
        this.exp += exp;
        if (this.exp >= level * 20) {
            levelUp();
        }
    }

    private void levelUp() {
        level++;
        health += 20;
        System.out.println("Level up! Sekarang level " + level);
    }

    public void addItem(String item) {
        inventory.add(item);
    }

    public boolean hasItem(String item) {
        return inventory.contains(item);
    }

    public void usePotion() {
        if (hasItem("Potion")) {
            inventory.remove("Potion");
            health += 20;
            if (health > 100) health = 100;
        }
    }
}