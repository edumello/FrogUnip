package frog.controller;

import frog.model.Score;
import frog.view.FramePadrao;
import frog.view.FrogJPanel;
import frog.view.Jogo;
import frog.view.MenuFim;
import frog.view.MenuInicio;

public class ControladorMenus{
    FramePadrao telaJogo;
    Score score;
    
    public ControladorMenus(){
        score = new Score();
    }
    
    public void start() {
        telaJogo = new FramePadrao(this);
    }
    
    public void setMenu(String menu) {
        FrogJPanel panel;
        switch (menu) {
            case "MenuInicio":
                panel = new MenuInicio();
                break;
            case "MenuFim":
                panel = new MenuFim(score);
                break;
            case "Jogo":
                panel = new Jogo(this, score);
                break;
            default:
                panel = new MenuInicio();
        }
        telaJogo.mudarMenu(panel);
    }
    
    public void startGame(Jogo jogo){
        jogo.getEngine().startGame();
    }
}
