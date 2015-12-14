package frog.model;

import java.util.Random;

public class Carro extends Obstaculo{
    private final String direcao;

    public Carro(int y, String direcao, int velocidade) {
        this.direcao = direcao;
        this.x = -125;
        if("DIREITA".equals(direcao)){
            this.x = 1000;
        }
        this.y = y;
        this.velocidade = velocidade;
        Random r = new Random();
        int randomCor = r.nextInt(3);
        String cor = "";
        if (randomCor == 0){
            cor = "Azul";
        }
        if (randomCor == 1){
            cor = "Amarelo";
        }
        if (randomCor == 2){
            cor = "Vermelho";
        }
        this.imagem = loadImage("/img/Carro_" + cor + "_" + direcao + ".png");
    }
    
    @Override
    public void move() {
        switch (this.direcao){
            case "DIREITA":
                this.x = this.x - velocidade;
                break;
            case "ESQUERDA":
                this.x =  this.x + velocidade;
                break;
        }
    }
}
