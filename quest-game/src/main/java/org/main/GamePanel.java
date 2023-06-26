package org.main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {
    private MouseInputs mouseInput;
    private float xDelta = 100, yDelta = 100;
    private BufferedImage image, subImage;

    public GamePanel() {
        mouseInput = new MouseInputs(this);
        importImage();
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInput);
        addMouseMotionListener(mouseInput);
    }

    private void importImage() {
        try {
            InputStream in = getClass().getResourceAsStream("/testes.png");
            assert in != null;
            image = ImageIO.read(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setPanelSize() {
        Dimension screenSize = new Dimension(1400, 800);
        setPreferredSize(screenSize);
    }

    public void changeXdelta(int value) {
        this.xDelta += value;
    }

    public void changeYdelta(int value) {
        this.yDelta += value;
    }

    public void setRectPos(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        subImage = image.getSubimage(0*69, 0 * 48, 69, 48);//Depends on the image
        g.drawImage(subImage, (int) xDelta, (int) yDelta, 128, 80, null);

    }


}
