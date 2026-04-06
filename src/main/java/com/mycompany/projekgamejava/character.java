package com.mycompany.projekgamejava;

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
<<<<<<< Updated upstream
            // Pastikan filenya sudah di-export ke .png dari LibreSprite
            InputStream is = getClass().getResourceAsStream("/Brimob.png");
=======
            // PERBAIKAN: Gunakan '/' di awal agar Java mencari dari folder root resources
            // Sesuaikan path-nya dengan struktur folder di resources nanti
            InputStream is = getClass().getResourceAsStream("/Brimob.png");
            
>>>>>>> Stashed changes
            if (is != null) {
                image = ImageIO.read(is);
                System.out.println("Status: Gambar Brimob Berhasil Dimuat!");
            } else {
                
                System.err.println("Error: File Brimob.png tidak ditemukan! Cek folder resources.");
            }
        } catch (Exception e) {
            System.err.println("Terjadi kesalahan saat membaca file.");
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d) {
        if (image != null) {
            // Opsional: Atur ukuran gambar di sini, misal 64x64 agar tidak terlalu besar/kecil
            g2d.drawImage(image, x, y, 64, 64, null);
        } else {
            
            g2d.setColor(java.awt.Color.RED);
            g2d.fillRect(x, y, 10, 10);
        }
    }
}