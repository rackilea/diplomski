import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class TestGui extends JFrame{

JPanel contentPane = new JPanel();
JButton button = new JButton("Press me!");
JComboBox comboBox = new JComboBox(new String[] {"None", "Help"});


public TestGui() {

    initalise();
}

private void initalise() {

    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    this.comboBox.setSelectedItem(null);    
    this.contentPane.setLayout(new GridLayout(2,1));
    this.contentPane.add(comboBox);
    this.contentPane.add(button);

    this.button.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            comboBox.removeItem(comboBox.getSelectedItem());
            comboBox.setSelectedItem(null);

        }
    });

    this.setContentPane(this.contentPane);

    this.pack();
    this.setVisible(true);
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {

            new TestGui();
        }
    });
}

}