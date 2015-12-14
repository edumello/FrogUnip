/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frog.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JLabel;

/**
 *
 * @author Eduardo
 */
public class MenuInicio extends FrogJPanel{
    private final Image background;
    private final JLabel titulo;
    private final JLabel btnComecar;
    

    public MenuInicio() {
        setName("MenuInicio");
        this.background = loadImage("/img/Background_Inicial.png");
        titulo = new JLabel();
        titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Titulo.png")));
        titulo.setName("Titulo");
        btnComecar = new JLabel();
        btnComecar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Start.png")));
        btnComecar.setName("Comecar");
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weighty = 1.0;   
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.insets = new Insets(10, 0, 0, 0);
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        constraints.gridy = 1;
        add(titulo, constraints);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 3;
        add(btnComecar, constraints);
    }
    
    private Image loadImage(String fileName) {
       Image img = null;    
        URL url= getClass().getResource(fileName);
        img =  Toolkit.getDefaultToolkit().getImage(url);
        return img;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.drawImage(background, 0, 0, this);
    }
}
