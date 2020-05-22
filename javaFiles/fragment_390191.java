import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class LightHeavy extends JFrame {

    private Component heavyweightComponent;
    private JPopupMenu backButton, forwardButton;

    public LightHeavy() {
        super("LightHeavy");
        heavyweightComponent = buildHeavyweightComponent();
        heavyweightComponent.setBackground(Color.ORANGE);
        heavyweightComponent.setSize(640, 480);
        getContentPane().add(heavyweightComponent, BorderLayout.CENTER);
        ImageIcon backArrow = new ImageIcon("left_arrow_128.png");
        backButton = buildPopup(backArrow);
        ImageIcon forwardArrow = new ImageIcon("right_arrow_128.png");
        forwardButton = buildPopup(forwardArrow);
        heavyweightComponent.addMouseMotionListener(new MouseInputAdapter() {
            public void mouseMoved(MouseEvent e) {
                Rectangle backHotSpot = new Rectangle(0, 0, 200, 200);
                Rectangle forwardHotSpot = new Rectangle(heavyweightComponent.getWidth() - 200, 0, 200, 200);
                if (backHotSpot.contains(e.getPoint())) {
                    backButton.show(heavyweightComponent, 0, 0);
                } else if (forwardHotSpot.contains(e.getPoint())) {
                    forwardButton.show(heavyweightComponent,
                            heavyweightComponent.getWidth() - forwardButton.getWidth(), 0);
                }
            }
        });

    }

    private Component buildHeavyweightComponent() {
        return new Canvas() {
            public void paint(Graphics og) {
                super.paint(og);
                Graphics2D g = (Graphics2D)og;

                String big = "Heavyweight Component";
                g.setFont(getFont().deriveFont(20F));
                Rectangle2D bigBounds = g.getFontMetrics().getStringBounds(big, g);
                g.drawString(big,
                        (this.getWidth() - (int)bigBounds.getWidth()) / 2,
                        (this.getHeight() - (int)bigBounds.getHeight()) / 2);

                String little = "(assume this is JDICplus)";
                g.setFont(getFont().deriveFont(10F));
                Rectangle2D littleBounds = g.getFontMetrics().getStringBounds(little, g);
                g.drawString(little,
                        (this.getWidth() - (int)littleBounds.getWidth()) / 2,
                        (this.getHeight() + (int)littleBounds.getHeight()) / 2);
            }
        };
    }

    private JPopupMenu buildPopup(Icon icon) {
        JButton button = new JButton(icon);
        JPopupMenu popup = new JPopupMenu();
        popup.add(button);
        popup.setBorderPainted(false);
        popup.setLightWeightPopupEnabled(false);
        return popup;
    }

    public static void main(String[] args) {
        JFrame f = new LightHeavy();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}