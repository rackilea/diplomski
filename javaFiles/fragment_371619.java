import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GameUI2 {

    private static final String IMG_PATH = "https://upload.wikimedia.org/wikipedia/commons/3/3f/"
            + "Butterfly_Nebula_in_narrow_band_Sulfur%2C_Hydrogen_and_Oxygen_Stephan_Hamel.jpg";
    private static final String BTN_IMG_PATH = "https://upload.wikimedia.org/wikipedia/commons/5/54/Crystal_Project_Games_kids.png";

    private static void createAndShowGui() {
        BufferedImage bgImg = null;
        BufferedImage btnImg = null;
        try {
            URL bgImgUrl = new URL(IMG_PATH);
            URL btnImgUrl = new URL(BTN_IMG_PATH);
            bgImg = ImageIO.read(bgImgUrl);
            btnImg = ImageIO.read(btnImgUrl);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }


        BackgroundPanel2 mainPanel = new BackgroundPanel2(bgImg);
        mainPanel.setLayout(new GridBagLayout());
        GamePanel2 gamePanel = new GamePanel2(btnImg); 
        mainPanel.add(gamePanel);        

        JFrame frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}