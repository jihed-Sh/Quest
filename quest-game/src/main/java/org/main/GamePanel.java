package org.main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utils.Constants.Directions.*;
import static utils.Constants.PlayerConstants.*;

public class GamePanel extends JPanel {
    private MouseInputs mouseInput;
    private float xDelta = 100, yDelta = 100;
    private BufferedImage image;
    private BufferedImage[][] animations;
    private int animationTick, animationIndex, animationSpeed = 15;
    private int playerAction = IDLE;
    private int playerDirection = -1;
    private boolean moving = false;

    public GamePanel() {
        mouseInput = new MouseInputs(this);
        importImage();
        loadAnimations();
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInput);
        addMouseMotionListener(mouseInput);
    }

    private void loadAnimations() {
        animations = new BufferedImage[8][6];
        for (int j = 0; j < animations.length; j++) {
            for (int i = 0; i < animations[j].length; i++) {
                animations[j][i] = image.getSubimage(i * 69, j * 48, 69, 48);//Depends on the image
            }
        }
    }

    private void importImage() {
        InputStream in = getClass().getResourceAsStream("/testes.png");
        try {

            assert in != null;
            image = ImageIO.read(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert in != null;
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void setPanelSize() {
        Dimension screenSize = new Dimension(1400, 800);
        setPreferredSize(screenSize);
    }

    public void setDirection(int direction) {
        this.playerDirection = direction;
        moving = true;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    private void updateAnimationTick() {
        animationTick++;
        if (animationTick >= animationSpeed) {
            animationTick = 0;
            animationIndex++;
            if (animationIndex >= GetSpriteAmount(playerAction)) {
                animationIndex = 0;
            }
        }
    }

    private void setAnimation() {
        if (moving) {
            playerAction = RUNNING;

        } else {
            playerAction = IDLE;
        }
    }

    private void updatePosition() {
        if (moving) {
            switch (playerDirection) {
                case LEFT:
                    xDelta -= 5;
                    break;
                case UP:
                    yDelta -= 5;
                    break;
                case DOWN:
                    yDelta += 5;
                    break;

                case RIGHT:
                    xDelta += 5;
                    break;

            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateAnimationTick();
        setAnimation();
        updatePosition();
        g.drawImage(animations[playerAction][animationIndex], (int) xDelta, (int) yDelta, 256, 160, null);

    }


}
