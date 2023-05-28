package org.main;
import javax.swing.JFrame;
public class GameWindow {
    private JFrame  frame;
    public GameWindow(GamePanel panel) {
        frame=new JFrame();
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
