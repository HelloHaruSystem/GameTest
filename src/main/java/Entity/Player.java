package Entity;

import UserInput.KeyHandler;
import UserInterface.GamePanel;

import java.awt.*;

public class Player extends Entity {

    GamePanel gamePanel;
    KeyHandler keyHandler;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        this.setDefaultValues();
    }

    public void setDefaultValues() {
        // sets the player's default position and speed which it can move on the screen
        this.x = 100;
        this.y = 100;
        this.speed = 4;

    }

    public void update() {
        // if the user pressed up (w) the player moves up and so on
        if (keyHandler.upPressed) {
            this.y -= this.speed;
        } else if (keyHandler.downPressed) {
            this.y += this.speed;
        } else if (keyHandler.leftPressed) {
            this.x -= this.speed;
        } else if (keyHandler.rightPressed) {
            this.x += this.speed;
        }

    }

    public void draw(Graphics g2d) {
        // setting color
        g2d.setColor(Color.WHITE);

        // drawing a rectangle to the screen
        // using tileSize variable
        // this will act as the player character for now
        g2d.fillRect(this.x, this.y, gamePanel.tileSize, gamePanel.tileSize);
    }

}
