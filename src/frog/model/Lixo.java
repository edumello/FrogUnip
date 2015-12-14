package frog.model;

import java.util.Random;

public class Lixo extends Obstaculo{
    public Lixo(int x, int y) {
        this.x = x;
        this.y = y;
        Random r = new Random();
        int randomTipo = r.nextInt(2);
        String tipo = "";
        if (randomTipo == 0) {
            tipo = "Sacola";
        }
        else if (randomTipo == 1) {
            tipo = "Garrafa";
        }
        this.imagem = loadImage("/img/" + tipo + ".png");
    }
    
    @Override
    void move() {
    //Não utiliza
    }
    
}
