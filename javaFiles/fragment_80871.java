import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


class MyPanel extends JPanel {

    private JTextField t;
    private JTextField v;

    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));

        JLabel l = new JLabel("THE STATUS OF AC IS ", JLabel.CENTER);

        JLabel p = new JLabel("THE STATUS OF HEATER IS", JLabel.CENTER);

        t = new JTextField("");
        v = new JTextField("");
        this.add(l);
        this.add(p);
        this.add(t);
        this.add(v);

    }

    public void updateState(String result) {

        String ac, ab;

        if ("aboveHT".equals(result) || "coolAir".equals(result)) {
            ac = "cooler on";
        } else {
            ac = "cooler off";
        }

        if ("belowHt".equals(result)) {
            ab = "Heater on";
        } else {
            ab = "Heater off";
        }

        t.setText(ac);
        v.setText(ab);

    }        
}