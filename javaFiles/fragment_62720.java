import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JFrame window = new Main();
                window.setVisible(true);
            }
        });        
    }

    public Main() {
        JButton east = new JButton("East");
        JButton west = new JButton("West");

        JPanel content = new JPanel();
        content.setLayout(new GridLayout(1, 2));

        content.add(east);
        content.add(west);

        setContentPane(content);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

}