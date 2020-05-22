import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class MilesKiloConverter {

private JTextField jtfMiles = new JTextField(15);
private JTextField jtfKilos = new JTextField(15);

private JLabel jlbMiles = new JLabel("miles");
private JLabel jlbKilos = new JLabel("km");

private JButton compute = new JButton("Compute");
private JFrame frame = new JFrame();

double km = 0;
double miles = 0;

public void createAndSHowGui() {
    JPanel p1 = new JPanel(new GridLayout(2, 2, 5, 5));
    p1.add(jtfMiles);
    p1.add(jlbMiles);
    p1.add(jtfKilos);
    p1.add(jlbKilos);

    frame.add(p1, BorderLayout.CENTER);
    frame.add(compute, BorderLayout.SOUTH);

    jtfMiles.setHorizontalAlignment(SwingConstants.RIGHT);
    jtfKilos.setHorizontalAlignment(SwingConstants.RIGHT);

    jtfKilos.setFocusable(true);


    compute.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            double newKm = 0;
            double newMiles = 0;

            if ("".equals(jtfMiles.getText())) {
                newKm = Double.parseDouble(jtfKilos.getText());
                jtfMiles.setText(String.valueOf(newKm * 1.62137));
                km = newKm;
            } else if ("".equals(jtfKilos.getText())) {
                newMiles = Double.parseDouble(jtfMiles.getText());
                jtfKilos.setText(String.valueOf(newMiles * 0.62137));

            } else {
                newMiles = Double.parseDouble(jtfMiles.getText());
                newKm = Double.parseDouble(jtfKilos.getText());

                double milesDiff = miles - newMiles;
                double kiloDiff = km - newKm;

                if (Math.abs(milesDiff) > Math.abs(kiloDiff)) {
                    jtfKilos.setText(String.valueOf(newMiles * 1.62137));
                    km = newKm;
                    miles = newMiles;
                } else {
                    jtfMiles.setText(String.valueOf(newKm * 0.62137));
                    km = newKm;
                    miles = newMiles;
                }
            }
        }
    });

    frame.setTitle("Miles/Kilometers Converter");
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

}

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable(){
        @Override
        public void run(){
            new MilesKiloConverter().createAndSHowGui();
        }
    });
}
}