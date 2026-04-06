package com.mycompany.projekgamejava;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements Runnable, KeyListener {
    character player = new character();
    Thread gameThread;
    
    // Status Tombol
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    
    // Pengaturan Game
    int FPS = 60;
    int speed = 7; // Ubah angka ini untuk mengatur kecepatan (semakin besar semakin cepat)

    public GamePanel() {
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(this);
        this.setFocusable(true);
        
        startGameThread();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();   // Logika pergerakan dijalankan di sini
                repaint();  // Gambar ulang layar
                delta--;
            }
        }
    }

    // LOGIKA PERGERAKAN HALUS
    public void update() {
        if (upPressed) {
            player.y -= speed;
        }
        if (downPressed) {
            player.y += speed;
        }
        if (leftPressed) {
            player.x -= speed;
        }
        if (rightPressed) {
            player.x += speed;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        player.draw(g2d);
        g2d.dispose();
    }

    // --- DETEKSI TOMBOL DITEKAN ---
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) upPressed = true;
        if (code == KeyEvent.VK_S) downPressed = true;
        if (code == KeyEvent.VK_A) leftPressed = true;
        if (code == KeyEvent.VK_D) rightPressed = true;
    }

    // --- DETEKSI TOMBOL DILEPAS ---
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) upPressed = false;
        if (code == KeyEvent.VK_S) downPressed = false;
        if (code == KeyEvent.VK_A) leftPressed = false;
        if (code == KeyEvent.VK_D) rightPressed = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}