package UserInterface;

import UserInput.KeyHandler;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // screen settings
    private final int originalTileSize = 16; // 16x16 tile
    private final int scale = 3;             // used to scale up so the 16x16 tiles doesn't look too small

    private final int tileSize = originalTileSize * scale; // 48x48 tile size

    // 16 horizontally, 12 tiles vertically
    private final int maxScreenColumn = 16;
    private final int maxScreenRow = 12;
    private final int screenWidth = tileSize * maxScreenColumn; // 769 pixels
    private final int screenHeight = tileSize * maxScreenRow;   // 576 pixels

    // setting the fps
    private final int framesperSecond = 60;

    // instantiating the key handler class
    KeyHandler keyHandler = new KeyHandler();

    // Main game Thread
    private Thread gameThread;

    // sets the player's default position
    private int playerX = 100;
    private int playerY = 100;
    private int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler); // adding key handler
        this.setFocusable(true); // with this the game panel can be able to receive key input
    }

    public void startGameThread() {
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    @Override
    public void run() {

        // 9 zeros / one billion nanoseconds
        double drawInterval = (double) 1000000000 / framesperSecond; // 0.01666 seconds
        double nextDrawTime = System.nanoTime() + drawInterval;

        // Main game loop
        while (this.gameThread != null) {

            // update the information such as character positions
            update();
            // draw the screen with the updated information
            repaint();


            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                // convert remaining time to milliseconds
                remainingTime = remainingTime / 1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void update() {

        // if the user pressed up (w) the player moves up and so on
        if (keyHandler.upPressed) {
            playerY -= playerSpeed;
        } else if (keyHandler.downPressed) {
            playerY += playerSpeed;
        } else if (keyHandler.leftPressed) {
            playerX -= playerSpeed;
        } else if (keyHandler.rightPressed) {
            playerX += playerSpeed;
        }

    }

    // using the paintComponent and Graphics class to paint to the canvas
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // changed Graphics g to graphics2D
        Graphics2D g2d = (Graphics2D) g;

        // setting color
        g2d.setColor(Color.WHITE);

        // drawing a rectangle to the screen
        // using tileSize variable
        // this will act as the player character for now
        g2d.fillRect(playerX, playerY, tileSize, tileSize);

        // dispose of this graphics context and release any system resources that is being used
        // this is good practice?
        g2d.dispose();
    }
}
