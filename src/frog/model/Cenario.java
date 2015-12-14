/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frog.model;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;

public class Cenario {
    private Image background;
    private final ArrayList<Carro> carros;
    private final ArrayList<Obstaculo> obstaculos;
    private final Sapo kako;
    
    public Cenario(Sapo kako){
        loadBackgroundImage();
        this.kako = kako;
        carros = new ArrayList();
        obstaculos = new ArrayList();
    }
    
    private void loadBackgroundImage() {
        URL url = getClass().getResource("/img/Cidade.png");
        background =  Toolkit.getDefaultToolkit().getImage(url);
    }

    public Image getBackground() {
        return background;
    }

    public void addCar(Carro carro){
        carros.add(carro);
    }
    
    public void addPedras(Pedra pedra){
        obstaculos.add(pedra);
    }
    
    public void addLixos(Obstaculo obstaculo){
        obstaculos.add(obstaculo);
    }

    public ArrayList<Carro> getCarros() {
        return carros;
    }

    public ArrayList<Obstaculo> getObstaculos() {
        return obstaculos;
    }
}
