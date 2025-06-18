package inputs;

import main.Game;
import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

// extends is for class and implements is for interface, we can inherit more than 1 interface but a class can only be one time
public class KeyboardInputs implements KeyListener {

    private GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> {
                gamePanel.changeYDelta(-5);
            }
            case KeyEvent.VK_A -> {
                gamePanel.changeXDelta(-5);
            }
            case KeyEvent.VK_S -> {
                gamePanel.changeYDelta(+5);
            }
            case KeyEvent.VK_D -> {
                gamePanel.changeXDelta(+5);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
