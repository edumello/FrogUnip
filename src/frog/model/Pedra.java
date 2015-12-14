package frog.model;

public class Pedra extends Obstaculo{

    public Pedra(int x, int y){
        this.x = x;
        this.y = y;
        this.imagem = loadImage("/img/Folha.png");
    }
    @Override
    void move() {
        //Não faz uso
    }
    
    @Override
    public void setVelocidade(int velocidade){
        //Não faz uso
    }
}
