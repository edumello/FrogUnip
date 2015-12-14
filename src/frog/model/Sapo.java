package frog.model;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;


public class Sapo {
    private Image imagem;
    private String direcao;
    private boolean vivo;
    private int x;
    private int y;
    private final int tamanhoX = 32;
    private final int tamanhoY = 25;
    private final int velocidadeX = tamanhoX*2;
    private final int velocidadeY = tamanhoY*2;

    public Sapo(){
        direcao = "CIMA";
        vivo = true;
        imagem = loadKakoImage();
        x = (int)(135 * 3f);
        y = 460;
    }

    public int getX() {
        return x;
    }
    
    public Image getImagem() {
        return imagem;
    }
    
    public int getY() {
        return y;
    }
    
    public boolean vivo(){
        return vivo;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getDirecao() {
        return direcao;
    }

    public Sapo setDirecao(String direcao) {
        this.direcao = direcao;
        return this;
    }
	
    public void move(ArrayList<Obstaculo> obstaculos) {
        if(vivo){
            switch (this.direcao){
                case "DIREITA":
                    this.x = this.x + velocidadeX;
                    this.imagem = loadKakoImage();
                    for (Obstaculo obstaculo : obstaculos) {
                        if(this.getBounds().intersects(obstaculo.getBounds())){
                            this.x = this.x - velocidadeX;
                            break;
                        }
                    }
                    if (this.x > 980) {
                        this.x = this.x - velocidadeX;
                    }
                    break;
                case "ESQUERDA":
                    this.x = this.x - velocidadeX;
                    this.imagem = loadKakoImage();
                    for (Obstaculo obstaculo : obstaculos) {
                        if(this.getBounds().intersects(obstaculo.getBounds())){
                            this.x = this.x + velocidadeX;
                            break;
                        }
                    }
                    if(this.x < 0){
                        this.x = this.x + velocidadeX;
                    }
                    break;
                case "CIMA":
                    this.y = this.y - velocidadeY;
                    this.imagem = loadKakoImage();
                    for (Obstaculo obstaculo : obstaculos) {
                        if(this.getBounds().intersects(obstaculo.getBounds())){
                            this.y = this.y + velocidadeY;
                            break;
                        }
                    }
                    if(this.y < 0){
                        this.y = this.y + velocidadeY;
                    }
                    break;
                case "BAIXO":
                    this.y = this.y + velocidadeY;
                    this.imagem = loadKakoImage();
                    for (Obstaculo obstaculo : obstaculos) {
                        if(this.getBounds().intersects(obstaculo.getBounds())){
                            this.y = this.y - velocidadeY;
                            break;
                        }
                    }
                    if(this.y > 500){
                        this.y = this.y - velocidadeY;
                    }
                    break;
            }
        }
    }
	
    public void matar(){
        vivo = false;
        imagem = loadKakoImage();
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, imagem.getWidth(null), imagem.getHeight(null));
    }
		
    private Image loadKakoImage(){
        Image img = null;
        String vida = "MORTO";
        if(vivo()){
            vida = "VIVO";
        }
        URL url = getClass().getResource("/img/Kako_" + getDirecao() + "_" + vida + ".png");
        img = Toolkit.getDefaultToolkit().getImage(url);
        return img;
    }
    
}