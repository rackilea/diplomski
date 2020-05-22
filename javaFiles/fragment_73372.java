import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorBands {

    public static void main(String[] args) {
        new ColorBands();
    }

    public ColorBands() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JPanel bandsPane;
        private JSlider slider;
        private Timer changeTimer;

        public TestPane() {
            bandsPane = new JPanel(new GridBagLayout());
            slider = new JSlider(1, 100);
            setLayout(new BorderLayout());
            add(new JScrollPane(bandsPane));
            add(slider, BorderLayout.SOUTH);
            slider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    changeTimer.restart();
                }
            });

            changeTimer = new Timer(250, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int bands = slider.getValue();
                    List<Color> bandsList = getColorBands(Color.RED, bands);
                    bandsPane.removeAll();
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridwidth = GridBagConstraints.REMAINDER;
                    gbc.insets = new Insets(1, 1, 1, 1);
                    for (Color color : bandsList) {
                        bandsPane.add(new ColorBand(color), gbc);
                    }
                    gbc.weighty = 1;
                    bandsPane.add(new JPanel(), gbc);
                    revalidate();
                    repaint();
                }
            });
            changeTimer.setRepeats(false);
            slider.setValue(1);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }

    public List<Color> getColorBands(Color color, int bands) {

        List<Color> colorBands = new ArrayList<>(bands);
        for (int index = 0; index < bands; index++) {
            colorBands.add(darken(color, (double) index / (double) bands));
        }
        return colorBands;

    }

    public static Color darken(Color color, double fraction) {

        int red = (int) Math.round(Math.max(0, color.getRed() - 255 * fraction));
        int green = (int) Math.round(Math.max(0, color.getGreen() - 255 * fraction));
        int blue = (int) Math.round(Math.max(0, color.getBlue() - 255 * fraction));

        int alpha = color.getAlpha();

        return new Color(red, green, blue, alpha);

    }

    public class ColorBand extends JPanel {

        public ColorBand(Color color) {
            setBackground(color);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 20);
        }

    }

}