import java.util.Scanner;

public class Game {
    private Scanner scanner;
    private Player player;
    private boolean gameOver;

    public Game(Scanner scanner) {
        this.scanner = scanner;
        this.gameOver = false;
    }

    public void start() {
        System.out.println("Selamat datang di MMORPG Apocalypse City!");
        System.out.println("Kota mati penuh dengan zombie. Tugasmu adalah mengeksplorasi dan bertahan hidup.");
        System.out.println("Buat karaktermu:");

        System.out.print("Masukkan nama pemain: ");
        String name = scanner.nextLine();
        player = new Player(name);

        System.out.println("Karakter " + player.getName() + " siap bertarung!");

        while (!gameOver) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    explore();
                    break;
                case 2:
                    checkStats();
                    break;
                case 3:
                    System.out.println("Terima kasih telah bermain!");
                    gameOver = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n=== Menu Utama ===");
        System.out.println("1. Eksplorasi Kota");
        System.out.println("2. Lihat Statistik");
        System.out.println("3. Keluar");
        System.out.print("Pilih: ");
    }

    private void explore() {
        System.out.println("Kamu mengeksplorasi kota mati...");
        // Random event: battle or find item
        int event = (int) (Math.random() * 3);
        if (event == 0) {
            System.out.println("Kamu menemukan item: Potion!");
            player.addItem("Potion");
        } else if (event == 1) {
            System.out.println("Kamu menemukan item: Senjata!");
            player.addItem("Senjata");
        } else {
            System.out.println("Zombie muncul!");
            battle();
        }
    }

    private void battle() {
        Zombie zombie = new Zombie();
        System.out.println("Zombie dengan health " + zombie.getHealth() + " muncul!");

        while (player.getHealth() > 0 && zombie.getHealth() > 0) {
            System.out.println("\nPilihan:");
            System.out.println("1. Serang");
            System.out.println("2. Gunakan Potion");
            System.out.print("Pilih: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                int damage = player.attack();
                zombie.takeDamage(damage);
                System.out.println("Kamu menyerang zombie dengan " + damage + " damage.");
            } else if (choice == 2) {
                if (player.hasItem("Potion")) {
                    player.usePotion();
                    System.out.println("Kamu menggunakan potion dan health +20.");
                } else {
                    System.out.println("Kamu tidak punya potion!");
                    continue;
                }
            }

            if (zombie.getHealth() > 0) {
                int zombieDamage = zombie.attack();
                player.takeDamage(zombieDamage);
                System.out.println("Zombie menyerangmu dengan " + zombieDamage + " damage.");
            }
        }

        if (player.getHealth() <= 0) {
            System.out.println("Kamu mati! Ending 1: Kematian.");
            gameOver = true;
        } else {
            System.out.println("Kamu mengalahkan zombie!");
            player.gainExp(10);
            // Check for endings
            checkEnding();
        }
    }

    private void checkStats() {
        System.out.println("Nama: " + player.getName());
        System.out.println("Health: " + player.getHealth());
        System.out.println("Level: " + player.getLevel());
        System.out.println("Exp: " + player.getExp());
        System.out.println("Inventory: " + player.getInventory());
    }

    private void checkEnding() {
        if (player.getLevel() >= 5) {
            System.out.println("Kamu mencapai level 5! Kamu menyelamatkan kota. Ending 2: Pahlawan.");
            gameOver = true;
        } else if (player.getInventory().contains("Senjata") && player.getExp() >= 50) {
            System.out.println("Dengan senjata dan pengalaman, kamu menjadi pemimpin. Ending 3: Pemimpin Baru.");
            gameOver = true;
        }
    }
}