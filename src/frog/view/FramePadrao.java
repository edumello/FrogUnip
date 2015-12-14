/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frog.view;

import frog.controller.ControladorMenus;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 * @author Eduardo
**/
public class FramePadrao extends JFrame{
    private FrogJPanel frameAtivo;
    private final ControladorMenus menus;
    private final Container container;
    
    public FramePadrao(ControladorMenus menus){
        this.setTitle("Frog - UNIP");
        container = getContentPane();
        this.menus = menus;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAtivo = new MenuInicio();
        AtualizarMenu();
        pack();
        this.setResizable(false);
        setSize(1000, 529);
        setVisible(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String botaoAcao = frameAtivo.getComponentAt(e.getPoint()).getName();
                if("Comecar".equals(botaoAcao)){
                    menus.setMenu("Jogo");
                    AtualizarMenu();
                    menus.startGame((Jogo)frameAtivo);
                }
            }
        });
    }
    
    private void AtualizarMenu(){
        container.removeAll();
        container.add(frameAtivo);
        container.validate();
    }
    
    public void mudarMenu(FrogJPanel panel){
        frameAtivo = panel;
        AtualizarMenu();
    }

}
