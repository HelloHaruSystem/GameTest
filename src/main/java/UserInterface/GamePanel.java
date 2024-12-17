package UserInterface;

import Entity.Player;
import UserInput.KeyHandler;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // screen settings
    private final int originalTileSize = 16; // 16x16 tile
    private final int scale = 3;             // used to scale up so the 16x16 tiles doesn't look too small

    // public for use when drawing tiles to the panel in other classes
    public final int tileSize = originalTileSize * scale; // 48x48 tile size

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

    // Player character
    Player player = new Player(this, keyHandler);

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
        // using the deltatime for consistent frame rates

        // 9 zeros / one billion nanoseconds
        double drawInterval = (double) 1000000000 / this.framesperSecond; // 0.01666 seconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCounter = 0;

        // Main game loop
        while (this.gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                // update the information such as character positions
                update();
                // draw the screen with the updated information
                repaint();
                delta--;
                drawCounter++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCounter);
                drawCounter = 0;
                timer = 0;
            }

        }

    }

    public void update() {
        player.update();
    }

    // using the paintComponent and Graphics class to paint to the canvas
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // changed Graphics g to graphics2D
        Graphics2D g2d = (Graphics2D) g;

        player.draw(g2d);

        // dispose of this graphics context and release any system resources that is being used
        // this is good practice?
        g2d.dispose();
    }
}
