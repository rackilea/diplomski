import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.File;
import javax.swing.JButton;

public class ListFiles
{
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,5));
        String path = ".";
        String file;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            file = listOfFiles[i].getName();
            panel.add( new JButton( file ) );
        }
        frame.add( panel ) ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}