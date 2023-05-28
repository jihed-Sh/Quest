package inputs;

import org.main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {
        private GamePanel   gamePanel;

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
                gamePanel.changeYdelta(-50);
                break;

            case KeyEvent.VK_DOWN:
                gamePanel.changeYdelta(50);
                break;

            case KeyEvent.VK_LEFT:
                gamePanel.changeXdelta(-50);
                break;
            case KeyEvent.VK_RIGHT:
                gamePanel.changeXdelta(50);
                break;
            default:
                System.out.println("random");
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
