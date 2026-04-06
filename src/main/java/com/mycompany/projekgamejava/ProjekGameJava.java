/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projekgamejava;

/**
 *
 * @author Zaid Akmal Firdaus
 */

import javax.swing.JFrame;

public class ProjekGameJava {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(new GamePanel());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}