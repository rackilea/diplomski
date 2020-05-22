import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicPanelUI;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel content = new JPanel(new GridBagLayout());
                // This will offset the content, so we can see that the code is working
                content.setBorder(new EmptyBorder(10, 10, 10, 10));
                frame.setContentPane(content);
                // Add multiple instances so we can see that the code is working
                frame.add(new TestPane());
                frame.add(new TestPane());
                frame.add(new TestPane());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setUI(new CustomPanelUI(Color.RED, Color.BLUE));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    public class CustomPanelUI extends BasicPanelUI {

        Color firstColor;
        Color secondColor;

        CustomPanelUI(Color firstColor, Color secondColor) {
            this.firstColor = firstColor;
            this.secondColor = secondColor;
        }

        @Override
        public void update(Graphics g, JComponent c) {
            if (c.isOpaque()) {
                Graphics2D g2 = (Graphics2D) g;

                g2.setPaint(new GradientPaint(
                                0,
                                c.getHeight() / 2,
                                firstColor,
                                c.getWidth(),
                                c.getHeight() / 2,
                                secondColor));

                g2.fillRect(0, 0, c.getWidth(), c.getHeight());
                g2.drawRect(0, 0, c.getWidth(), c.getHeight());
            }

            paint(g, c);
        }
    }

}