package UserInput;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // using KeyCodes
        int code = e.getKeyCode();

        // if user pressed W
        if (code == KeyEvent.VK_W) {

        }
        if (code == KeyEvent.VK_W) {

        }
        if (code == KeyEvent.VK_W) {

        }
        if (code == KeyEvent.VK_W) {

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
