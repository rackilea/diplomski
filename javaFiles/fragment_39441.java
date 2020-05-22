import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUILayout {

    public static void main(String[] args) {

        JFrame jf = new JFrame();
        JButton jbO = new JButton("CSIS0396");
        JButton jbl = new JButton("Final");
        JButton jb2 = new JButton("2010");
        JButton jb3 = new JButton("Exam");

        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();

        JButton object_btn = new JButton("Object");
        JButton oriented_btn = new JButton("Oriented");
        JButton programming_btn = new JButton("Programming");
        JButton and_btn = new JButton("and");
        JButton java_btn = new JButton("Java");

        BorderLayout layout = new BorderLayout();

        panel2.setLayout(layout);
        panel.setLayout( new BoxLayout(panel, BoxLayout.PAGE_AXIS));


        panel.add(object_btn);
        panel.add(oriented_btn);
        panel.add(programming_btn);
        panel.add(and_btn);
        panel.add(java_btn);

        panel2.add(BorderLayout.NORTH, jbO);
        panel2.add(BorderLayout.SOUTH, jb2);
        panel2.add(BorderLayout.WEST, jbl);
        panel2.add(BorderLayout.EAST, jb3);

        panel.setBackground(Color.GREEN);
        panel2.setBackground(Color.RED);

        jf.setLayout(new BorderLayout());
        jf.getContentPane().add(panel ,BorderLayout.WEST);
        jf.getContentPane().add(panel2, BorderLayout.EAST);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(400, 300);
        jf.setVisible(true);

    }

}