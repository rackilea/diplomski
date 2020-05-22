import java.awt.*;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class PanelGB extends JPanel {

    JLabel nombre = new JLabel("Nombre1", SwingConstants.CENTER);
    JLabel grupo = new JLabel("Grupo1", SwingConstants.LEFT);
    JLabel cod1 = new JLabel("01", SwingConstants.CENTER);
    JLabel cod2 = new JLabel("243", SwingConstants.CENTER);
    JButton btn = new JButton("B");

    public PanelGB() {
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        // make the entire GUI less cramed up & 'crowded'
        gbc.insets = new Insets(4, 4, 4, 4);

        setBorder(BorderFactory.createLineBorder(Color.red));
        // give the label more horizontal white space using an empty border..
        nombre.setBorder(new CompoundBorder(new EmptyBorder(0, 40, 4, 40), 
                BorderFactory.createLineBorder(Color.black)));
        grupo.setBorder(BorderFactory.createLineBorder(Color.black));
        cod1.setBorder(BorderFactory.createLineBorder(Color.black));
        cod2.setBorder(BorderFactory.createLineBorder(Color.black));
        grupo.setAlignmentX(0);

        this.setLayout(gbl);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.gridheight = 2;
        add(nombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 5;
        gbc.gridheight = 1;
        // push the label to the start of the line
        gbc.anchor = GridBagConstraints.LINE_START;
        add(grupo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        add(cod1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        add(cod2, gbc);

        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        // push the button to the end
        gbc.anchor = GridBagConstraints.LINE_END;
        add(btn, gbc);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new PanelGB());
        frame.pack();
        frame.setVisible(true);
    }
}