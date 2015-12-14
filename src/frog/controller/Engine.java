package frog.controller;

import frog.model.Carro;
import frog.model.Lixo;
import frog.model.Obstaculo;
import frog.model.Sapo;
import frog.model.Score;
import frog.view.*;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

public class Engine {
    Timer rio;
    Timer rua;
    Jogo jogo;
    Sapo kako;
    ArrayList<Carro> carros;
    ArrayList<Obstaculo> obstaculos;
    Score score;
    int velocidade;
    
    public Engine(Jogo jogo){
        this.jogo = jogo;
        kako = jogo.getKako();
        carros = jogo.getCarros();
        obstaculos = jogo.getObstaculos();
        score = jogo.getScore();
        velocidade = 0;
    }

    public void startGame(){
        score.atualizar(0);
        //Solicita Focus para os Listeners.
        jogo.requestFocus();
        jogo.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(kako.vivo()){
                    if (e.getKeyCode() == KeyEvent.VK_UP) {
                        kako.setDirecao("CIMA").move(obstaculos);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                        kako.setDirecao("BAIXO").move(obstaculos);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        kako.setDirecao("ESQUERDA").move(obstaculos);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        kako.setDirecao("DIREITA").move(obstaculos);
                    }
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                //Não faz uso.
            }
            @Override
            public void keyTyped(KeyEvent e) {
                //Não faz uso.
            }
        });
        gameRua();
    }

    public void gameRua(){
        rua = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int faixa = random.nextInt(30);
                if(faixa >0 && faixa < 4){
                    Carro carro;
                    if(faixa == 2){
                        carro = new Carro(200, "DIREITA", 8 + velocidade);
                    }
                    else{
                        carro = new Carro(faixa * 100, "ESQUERDA", 8 + velocidade);
                    }
                    if (!verificaSpawn(carro.getBounds())) {
                        jogo.getCenario().addCar(carro);
                    }
                }
                jogo.repaint();
                verificaLevelUp();
            }
        });
        rua.start();
    }
    
   
    public void stopGame(){
        rua.stop();
    }
    
    private void levelUp(Jogo jogo){
        jogo.getScore().atualizar( score.getScore() + 1 + (obstaculos.size()*2) );
        Random random = new Random();
        int objetos = random.nextInt(3);
        do{
            Lixo lixo = new Lixo((random.nextInt(30)*34) + 8, (random.nextInt(3)*100)+100);
            obstaculos.add(lixo);
            objetos--;
        }while( objetos > -1 );
    }
    
    private void verificaLevelUp() {
        if (kako.getY() < 50) {
            kako.setPosition(kako.getX(), 460);
            levelUp(jogo);
            for (Carro carro : carros) {
                carro.setVelocidade(8 + velocidade);
            }
        }
    }
    
    
    private boolean verificaSpawn(Rectangle objeto) {
        for ( Carro carro : carros) {
            if (carro.getBounds().intersects(objeto)) {
                return true;
            }
        }
        return false;
    }
}