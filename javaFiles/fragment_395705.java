import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JPanelOne extends JPanel
{

        public JPanelOne()
        {
                // setting up black JPanel
                JPanel panel = new JPanel();
                panel.setPreferredSize(new Dimension(220, 40));
                panel.setBackground(Color.BLACK);

                // creating button on external JPanel
                JButton button = new JButton("Button (+JPanel) from external class");

                // adding button to the black JPanel
                panel.add(button);

                // adding blackJPanel
                add(panel);
        }
}