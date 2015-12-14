package frog.view;

import frog.controller.ControladorMenus;
import frog.controller.Engine;
import frog.model.Carro;
import frog.model.Cenario;
import frog.model.Obstaculo;
import frog.model.Sapo;
import frog.model.Score;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class Jogo extends FrogJPanel{
    private final Image background;
    private final Cenario cenario;
    private final Sapo kako;
    ArrayList<Carro> carros;
    ArrayList<Obstaculo> obstaculos;
    Engine engine;
    Score score;
    ControladorMenus menus;
    Timer timer;

    public Jogo(ControladorMenus menus, Score score) {
        this.menus = menus;
        this.score = score;
        kako = new Sapo();
        cenario = new Cenario(kako);
        carros = cenario.getCarros();
        obstaculos = cenario.getObstaculos();
        setName("Jogo");
        setFocusable(true);
        background = cenario.getBackground();
        this.engine = new Engine(this);
        timer = null;
    }
    
    public ArrayList<Carro> getCarros() {
        return carros;
    }

    public ArrayList<Obstaculo> getObstaculos() {
        return obstaculos;
    }

    public Sapo getKako() {
        return kako;
    }

    public Cenario getCenario() {
        return cenario;
    }

    public Engine getEngine() {
        return engine;
    }

    public Score getScore() {
        return score;
    }

    public ControladorMenus getMenus() {
        return menus;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.drawImage(background, 0, 00, this);
        g.drawImage(score.getTexto(), 1,1, this);
        g.drawImage(score.getDigito0(), 90,4, this);
        g.drawImage(score.getDigito1(), 110,4, this);
        g.drawImage(score.getDigito2(), 130,4, this);
        g.drawImage(score.getDigito3(), 150,4, this);
        if(kako.vivo()){
            gamePaint(g);
        }
        else{
            gameOver(g);
            score.atualizarRecord(score.getScore());
        }
    }  
    
    private void gameOver(Graphics g){
        kako.matar();
        g.drawImage(kako.getImagem(), kako.getX(), kako.getY(), this);
        for (Carro carro : carros) {
            g.drawImage(carro.getImagem(), carro.getX(), carro.getY(), this);
        }
        if(timer == null){
            timer = new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    score.atualizarRecord(score.getScore());
                    menus.setMenu("MenuFim");
                    timer.stop();
                }
            });
            timer.start();
        }

    }
    
    private void gamePaint(Graphics g){
        Carro carro;
        for (Obstaculo obstaculo : obstaculos) {
            g.drawImage(obstaculo.getImagem(), obstaculo.getX(), obstaculo.getY(), this);
        }
        g.drawImage(kako.getImagem(), kako.getX(), kako.getY(), this);
        for (int i = 0; i < carros.size(); i++) {
            carro = carros.get(i);
            carro.move();
            g.drawImage(carro.getImagem(), carro.getX(), carro.getY(), this);
            if (carro.getBounds().intersects(kako.getBounds())) {
                kako.matar();
//                engine.stopGame();
                paintComponent(g);
            }
            if (carro.getX() < -125 || carro.getX() > 1125) {
                carros.remove(i);
            }
        }
       
    }
}