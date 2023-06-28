package entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utils.Constants.PlayerConstants.*;

public class Player extends Entity {
    private final int animationSpeed = 15;
    private BufferedImage[][] animations;
    private int animationTick;
    private int animationIndex;
    private int playerAction = IDLE;
    private boolean moving = false,attacking=false;
    private boolean left, up, right, down;

    private final float playerSpeed = 2.00f;


    public Player(float x, float y) {
        super(x, y);
        loadAnimations();
    }

    public void update() {
        updatePosition();
        updateAnimationTick();
        setAnimation();
    }

    public void render(Graphics g) {
        g.drawImage(animations[playerAction][animationIndex], (int) x, (int) y, 256, 160, null);

    }

    private void loadAnimations() {
        InputStream in = getClass().getResourceAsStream("/testes.png");
        try {
            assert in != null;
            BufferedImage image = ImageIO.read(in);
            animations = new BufferedImage[8][6];
            for (int j = 0; j < animations.length; j++) {
                for (int i = 0; i < animations[j].length; i++) {
                    animations[j][i] = image.getSubimage(i * 72, j * 48, 72, 48);//Depends on the image
                }
            }
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


    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
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
                attacking=false;
            }
        }
    }

    private void setAnimation() {
        int startAnimation =playerAction;
        if (moving) {
            playerAction = RUNNING;

        } else {
            playerAction = IDLE;
        }
        if(attacking){
            playerAction=ATTACK;
        }
        if(startAnimation!=playerAction){
            resetAnimationTick();
        }
    }

    private void resetAnimationTick() {
        animationTick=0;
        animationIndex=0;

    }

    private void updatePosition() {
        moving=false;
        if (left && !right) {
            x -= playerSpeed;
            moving=true;
        } else if (right && !left) {
            x += playerSpeed;
            moving=true;
        }
        if (up && !down) {
            y -= playerSpeed;
            moving=true;
        } else if (down && !up) {
            y += playerSpeed;
            moving=true;
        }

    }


    public void resetDirBooleans() {
        left =false;
        right =false;
        up =false;
        down =false;
    }
}



