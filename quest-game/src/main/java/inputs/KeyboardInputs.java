package inputs;

import org.main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static utils.Constants.Directions.*;

public class KeyboardInputs implements KeyListener {
    private final GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                gamePanel.getGame().getPlayer().setUp(true);
                break;

            case KeyEvent.VK_DOWN:
                gamePanel.getGame().getPlayer().setDown(true);
                break;

            case KeyEvent.VK_LEFT:
                gamePanel.getGame().getPlayer().setLeft(true);
                break;
            case KeyEvent.VK_RIGHT:
                gamePanel.getGame().getPlayer().setRight(true);
                break;
            default:
                System.out.println("random");
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                gamePanel.getGame().getPlayer().setUp(false);
            case KeyEvent.VK_RIGHT:
                gamePanel.getGame().getPlayer().setRight(false);
            case KeyEvent.VK_LEFT:
                gamePanel.getGame().getPlayer().setLeft(false);
            case KeyEvent.VK_DOWN:
                gamePanel.getGame().getPlayer().setDown(false);
                break;
            default:
                System.out.println("random");
                break;
        }

    }
}
