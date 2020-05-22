import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ListView {

    public static void main(String[] args) throws IOException {
        String path = "C:/Documents and Settings/All Users/Documents/" +
            "My Pictures/Sample Pictures";
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        DefaultListModel listModel = new DefaultListModel();
        int count = 0;
        for (int i = 0; i < listOfFiles.length; i++)
        {
            System.out.println("check path"+listOfFiles[i]);
            String name = listOfFiles[i].toString();
            // load only JPEGs
            if ( name.endsWith("jpg") ) {
                ImageIcon ii = new ImageIcon(ImageIO.read(listOfFiles[i]));
                listModel.add(count++, ii);
            }
        }
        JList lsm=new JList(listModel);
        lsm.setVisibleRowCount(1);

        frame.add(new JScrollPane(lsm));

        frame.pack();
        frame.setVisible(true);
    }
}