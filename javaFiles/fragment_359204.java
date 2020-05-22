import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

class PlayerGui {

    public static void main(String[] args) {
        JPanel gui = new JPanel(new BorderLayout());
        gui.setBorder(new BevelBorder(BevelBorder.RAISED));

        JPanel north = new JPanel(new GridLayout(0,1,5,5));
        north.add(new JLabel("Player Name", SwingConstants.CENTER));

        JPanel tfConstrain = new JPanel(new FlowLayout(FlowLayout.CENTER));
        tfConstrain.add(new JTextField(18));

        north.add(tfConstrain);

        gui.add(north, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(0,1,10,10));
        center.add(new JButton("On This Machine"));
        center.add(new JButton("Netowrk Based"));
        center.add(new JButton("Main Menu"));
        center.setBorder(new EmptyBorder(40,70,40,70));

        gui.add(center, BorderLayout.CENTER);

        JOptionPane.showMessageDialog(null, gui);
    }
}