package UserInterface;

import javax.swing.*;

public class RootWindow {

    public RootWindow() {
        JFrame root = new JFrame();
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setResizable(false);
        root.setTitle("Haru's First Take");

        // adding game panel from the GamePanel class
        GamePanel gamePanel = new GamePanel();
        root.add(gamePanel);

        // pack() makes it so the window will be sized to fit the preferred size and layouts of the subcomponents
        // in this case the gamePanel
        root.pack();

        root.setLocationRelativeTo(null); // sets to the middle of the screen
        root.setVisible(true);
    }
}
