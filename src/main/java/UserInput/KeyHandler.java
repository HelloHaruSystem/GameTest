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

        // if user pressed W and so on
        if (code == KeyEvent.VK_W) {
            this.upPressed = true;
        }
        if (code == KeyEvent.VK_S) {
            this.downPressed = true;
        }
        if (code == KeyEvent.VK_A) {
            this.leftPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            this.rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            this.upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            this.downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            this.leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            this.rightPressed = false;
        }

    }

}
