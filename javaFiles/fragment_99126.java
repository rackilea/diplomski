import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GearFonts {

    private JComponent ui = null;
    int codepoint = 9881;
    String gearSymbol = new String(Character.toChars(codepoint));

    GearFonts() {
        initUI();
    }

    public void initUI() {
        if (ui!=null) return;

        ui = new JPanel(new GridLayout(0,2,5,5));
        ui.setBorder(new EmptyBorder(4,4,4,4));

        Font[] fonts = GraphicsEnvironment.
                getLocalGraphicsEnvironment().getAllFonts();
        for (Font font : fonts) {
            if (font.canDisplay(codepoint)) {
                JButton button = new JButton(gearSymbol + " " + font.getName());
                button.setFont(font.deriveFont(15f));
                ui.add(button);
            }
        }
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                GearFonts o = new GearFonts();

                JFrame f = new JFrame(o.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}