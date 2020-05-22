import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TestImage {
    public static final String SOMME_PATH = "https://upload.wikimedia.org/"
            + "wikipedia/commons/thumb/f/fa/Cheshire_Regiment_trench_Somme_1916.jpg"
            + "/1024px-Cheshire_Regiment_trench_Somme_1916.jpg";
    public static final String BATTLE_PATH = "https://upload.wikimedia.org/wikipedia/"
            + "commons/1/13/K%C3%A4mpfe_auf_dem_Doberdo.JPG";

    public static void main(String[] args) {
        int imgW = 1000;
        int imgH = 700;
        MyImage myImage = new MyImage(imgW, imgH, BufferedImage.TYPE_INT_ARGB);
        BufferedImage sommeTrench = null;
        BufferedImage battleOfDoberdò = null;

        try {
            URL url = new URL(SOMME_PATH);
            sommeTrench = ImageIO.read(url);

            url = new URL(BATTLE_PATH);
            battleOfDoberdò = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        Icon icon = new ImageIcon(myImage);
        JOptionPane.showMessageDialog(null, icon, "Original MyImage", JOptionPane.PLAIN_MESSAGE);

        myImage.copyImage(sommeTrench);
        icon = new ImageIcon(myImage);
        JOptionPane.showMessageDialog(null, icon, "MyImage with Somme Trench", JOptionPane.PLAIN_MESSAGE);

        myImage.copyImage(battleOfDoberdò);        
        icon = new ImageIcon(myImage);
        JOptionPane.showMessageDialog(null, icon, "MyImage with Battle Of Doberdò", JOptionPane.PLAIN_MESSAGE);

    }
}