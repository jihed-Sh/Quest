package org.main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final MouseInputs mouseInput;
    private Game game;
    public GamePanel(Game game) {
        this.game = game;
        mouseInput = new MouseInputs(this);
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInput);
        addMouseMotionListener(mouseInput);
    }


    public Game getGame() {
        return game;
    }

    private void setPanelSize() {
        Dimension screenSize = new Dimension(1400, 800);
        setPreferredSize(screenSize);
    }


    public void updateGame() {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.render(g);
    }

}
