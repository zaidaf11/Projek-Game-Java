/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projekgamejava;

/**
 *
 * @author DELL
 */
// Ganti dengan nama package kamu
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.InputStream;

public class character {
    public int x = 20;
    public int y = 20;
    private BufferedImage image;

    public character() {
        try {
            // Pastikan filenya sudah di-export ke .png dari LibreSprite
            InputStream is = getClass().getResourceAsStream("/Brimob.png");
            if (is != null) {
                image = ImageIO.read(is);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d) {
        if (image != null) {
            g2d.drawImage(image, x, y, null);
        } else {
            g2d.setColor(java.awt.Color.RED);
            g2d.fillRect(x, y, 10, 10);
        }
    }
}