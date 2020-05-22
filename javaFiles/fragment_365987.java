import java.awt.BorderLayout;
import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Main {

    public static void main(String[] args0) {

        try {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //use public resources when posting questions or answers
            URL url = new URL("http://www.digitalphotoartistry.com/rose1.jpg");
            ImageIcon image= new ImageIcon(url);
            JLabel imageLabel = new JLabel(image);
            //add the label to the frame using the default layout manager (BorderLayout)
            frame.add(imageLabel); //add label to the default position BorderLayout.CENTER
            //frame.setLayout(null); //do not use null layout
            //imageLabel.setLocation(0, 0); //do not set bounds, that is the job of the layout manager

            JTextField t1 =new JTextField("Welcome to Javatpoint.");
            frame.add(t1, BorderLayout.SOUTH); //add text field to the frame using BorderLayout other position
            frame.pack();
            frame.setVisible(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}