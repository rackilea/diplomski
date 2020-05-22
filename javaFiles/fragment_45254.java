import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ThreeButtonAlignedLeft {

    private JComponent ui = null;
    private String prefix = "http://i.stack.imgur.com/";
    private String[] suffix = {"gJmeJ.png","T5uTa.png","wCF8S.png"};

    ThreeButtonAlignedLeft() {
        try {
            initUI();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
    }

    public void initUI() throws MalformedURLException {
        if (ui!=null) return;

        ui = new JPanel(new BorderLayout(4,4));
        ui.setBorder(new EmptyBorder(4,4,4,4));

        JPanel buttonContainer = new JPanel(new GridLayout(0, 1, 5, 5));
        for (int ii=0; ii<suffix.length; ii++) {
            JButton b = new JButton(new ImageIcon(new URL(prefix + suffix[ii])));
            b.setBorderPainted(false);
            b.setMargin(new Insets(0,0,0,0));
            b.setContentAreaFilled(false);
            buttonContainer.add(b);
        }
        JPanel buttonConstrainPanel = new JPanel(new BorderLayout(0, 0));
        buttonConstrainPanel.add(buttonContainer, BorderLayout.PAGE_START);

        ui.add(buttonConstrainPanel, BorderLayout.LINE_START);
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                ThreeButtonAlignedLeft o = new ThreeButtonAlignedLeft();

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