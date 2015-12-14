package frog.model;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import javax.swing.filechooser.FileSystemView;

public final class Score {
    private final Image textoScore;
    private Image digito0;
    private Image digito1;
    private Image digito2;
    private Image digito3;
    private int score;
    private int record;
    
    public Score(){
        textoScore = loadImage("/img/Score.png");
        verificarRecord();
        atualizar(0);
    }
    
    public Image getDigito0() {
        return digito0;
    }

    public Image getTexto() {
        return textoScore;
    }

    public Image getDigito1() {
        return digito1;
    }

    public Image getDigito2() {
        return digito2;
    }

    public Image getDigito3() {
        return digito3;
    }

    public int getScore() {
        return score;
    }
    
    public int getRecord() {
        return record;
    }
    
    private void verificarRecord(){
        BufferedReader reader = null;
        String novoRecord = null;
        try {
            reader = new BufferedReader(new FileReader(FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\unipFrogRecord.txt"));
            while ((novoRecord = reader.readLine()) != null) {
                record = Integer.valueOf(novoRecord);
            }
        } catch (IOException e) {
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
    }
    
    public void atualizarRecord(int novoScore){
        if(novoScore > record){
            this.record = novoScore;
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\unipFrogRecord.txt"));
                writer.write(String.valueOf(record));

            } catch (IOException e) {
            } finally {
                try {
                    if (writer != null) {
                        writer.close();
                    }
                } catch (IOException e) {
                }
            }
        }
    }
   
   private Image loadImage(String fileName){
        Image img = null;    
        URL url= getClass().getResource(fileName);
        img =  Toolkit.getDefaultToolkit().getImage(url);
        return img;
    }
   
    public void atualizar (int score){
        this.score = score;
        String scoreString = String.valueOf(score);
        switch(scoreString.length()){
            case 1:
                digito0 = loadImage("/img/0.png");
                digito1 = loadImage("/img/0.png");
                digito2 = loadImage("/img/0.png");
                digito3 = loadImage("/img/" + scoreString.charAt(0) + ".png");
                break;
            case 2:
                digito0 = loadImage("/img/0.png");
                digito1 = loadImage("/img/0.png");
                digito2 = loadImage("/img/" + scoreString.charAt(0) + ".png");
                digito3 = loadImage("/img/" + scoreString.charAt(1) + ".png");
                break;
            case 3:
                digito0 = loadImage("/img/0.png");
                digito1 = loadImage("/img/" + scoreString.charAt(0) + ".png");
                digito2 = loadImage("/img/" + scoreString.charAt(1) + ".png");
                digito3 = loadImage("/img/" + scoreString.charAt(2) + ".png");
                break;
            case 4:
                digito0 = loadImage("/img/" + scoreString.charAt(0) + ".png");
                digito1 = loadImage("/img/" + scoreString.charAt(1) + ".png");
                digito2 = loadImage("/img/" + scoreString.charAt(2) + ".png");
                digito3 = loadImage("/img/" + scoreString.charAt(3) + ".png");
                break;
        }
   }
}
