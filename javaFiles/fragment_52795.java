import java.awt.Graphics;
import javax.swing.*;
public class canvas extends JPanel {
    int i, count;
    public String read_string = "";
    public String[] names = {"Duncan","Matthew","Kevin","Etc"};
    public String[] searchfor = {"Duncan","Kevin"};

    @Override
    public void paintComponent(Graphics g) {
        for(i=0; i<names.length; i++) {
            read_string = names[i];
            if(read_string.contains("Duncan") ||
               read_string.contains("Kevin")) {
                count++;
                System.out.println(read_string);
                drawThatText(g, read_string, 50*i + 10, 50*i + 10);
            }
        }
    }

    public void drawThatText(Graphics g, String s, int x, int y) {
        g.drawString(s, x, y);
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setContentPane(new canvas());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(200, 200);
        jf.setVisible(true);
    }
}