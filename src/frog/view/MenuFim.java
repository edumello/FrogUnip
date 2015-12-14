/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frog.view;

import frog.model.Score;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JLabel;

public class MenuFim extends FrogJPanel{
    Image background;
    Image scoreTexto;
    Image recordTexto;
    Score score;
    int scoreValor;
    int recordValor;
    private final JLabel btnPlayAgain;
    
    public MenuFim(Score score){
        this.score = score;
        setName("MenuFim");
        this.background = loadImage("/img/Background_Final.png");
        btnPlayAgain = new JLabel();
        btnPlayAgain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Play_Again.png")));
        btnPlayAgain.setName("Comecar");
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(btnPlayAgain, constraints);
        
        scoreTexto = loadImage("/img/Score_fim.png");
        recordTexto = loadImage("/img/Record.png");
        scoreValor = score.getScore();
        recordValor = score.getRecord();
    }
    
    private Image loadImage(String fileName) {
        Image img = null;
        URL url = getClass().getResource(fileName);
        img = Toolkit.getDefaultToolkit().getImage(url);
        return img;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.drawImage(background, 0, 0, this);
        g.drawImage(scoreTexto, 250, 50, this);
        g.drawImage(recordTexto, 550, 50, this);
        score.atualizar(scoreValor);
        g.drawImage(score.getDigito0(), 332, 120, this);
        g.drawImage(score.getDigito1(), 352, 120, this);
        g.drawImage(score.getDigito2(), 372, 120, this);
        g.drawImage(score.getDigito3(), 392, 120, this);
        score.atualizar(recordValor);
        g.drawImage(score.getDigito0(), 600, 120, this);
        g.drawImage(score.getDigito1(), 620, 120, this);
        g.drawImage(score.getDigito2(), 640, 120, this);
        g.drawImage(score.getDigito3(), 660, 120, this);
    }
}
