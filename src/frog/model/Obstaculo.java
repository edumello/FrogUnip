package frog.model;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.net.URL;

public abstract class Obstaculo {
    protected int x;
    protected int y;
    protected Image imagem;
    protected int velocidade;
       
    //Retorna posicao X
    public int getX(){
        return x;
    };
    //Retorna posicao Y
    public int getY(){
        return y;
    };
    
    //Altera (x,y)
    abstract void move();
    
    //Retorna imagem
    public Image getImagem(){
        return imagem;
    }
       
    //Altera velocidade
    public void setVelocidade(int velocidade){
        this.velocidade = velocidade; 
    }
    //Retorna um retangulo representando o objeto
    public Rectangle getBounds(){
        return new Rectangle(x, y, imagem.getWidth(null), imagem.getHeight(null));
    }
    //Seta imagem
    protected Image loadImage(String fileName){
        Image img = null;    
        URL url= getClass().getResource(fileName);
        img =  Toolkit.getDefaultToolkit().getImage(url);
        return img;
    }
}
