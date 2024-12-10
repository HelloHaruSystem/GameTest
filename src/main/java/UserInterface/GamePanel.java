package UserInterface;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // screen settings
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3;             // used to scale up so the 16x16 tiles doesn't look too small

    final int tileSize = originalTileSize * scale; // 48x48 tile size

    // 16 horizontally, 12 tiles vertically
    final int maxScreenColumn = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenColumn; // 769 pixels
    final int screenHeight = tileSize * maxScreenRow;   // 576 pixels

    // Main game Thread
    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    @Override
    public void run() {
        // Main game loop
    }
}
