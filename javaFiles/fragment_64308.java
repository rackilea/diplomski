import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestFrame {
    JFrame jframe;
    NewPanel jpanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TestFrame());
    }

    public TestFrame(){
        jframe = new JFrame();  // without above addition frame won't resize
        jpanel = new NewPanel(); 
        jframe.add(jpanel);
        jframe.pack();
        jframe.setVisible(true);
    }

    class NewPanel extends JPanel implements ActionListener{
        public NewPanel(){
            JTextField textField = new JTextField (10);
            textField.addActionListener(this);
            this.add(textField);
        }

        // Adds a label when action is performed on textfield
        @Override
        public void actionPerformed(ActionEvent ae){
            System.out.println("WOLOLO");
            JPanel extraPanel = new JPanel();
            extraPanel.add(new JLabel("hi"));
            this.add(extraPanel);
            this.revalidate();
            this.repaint();
            jframe.pack();
        }
    }
}