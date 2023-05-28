package org.main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private  MouseInputs mouseInput ;
    private int xDelta =100 , yDelta =100;
    public GamePanel() {
        mouseInput = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInput);
        addMouseMotionListener(mouseInput);
    }
    public void changeXdelta(int value){
        this.xDelta += value;
        repaint();
    }
    public void changeYdelta(int value){
        this.yDelta += value;
        repaint();
    }
    public void setRectPos(int x, int y){
        this.xDelta = x;
        this.yDelta = y;
        repaint();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(this.xDelta,this.yDelta,200,50);
    }

}
