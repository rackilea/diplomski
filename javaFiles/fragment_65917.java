import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class Test1 {

    public static void main(String[] args) {
        new Test1();
    }

    public Test1() {
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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JPanel content;
        private CardLayout cardLayout;

        private ColorPane colorPane;
        private NumberPane numberPane;

        public TestPane() {
            setLayout(new BorderLayout());

            colorPane = new ColorPane();
            numberPane = new NumberPane();

            cardLayout = new CardLayout();

            content = new JPanel(cardLayout);
            content.add(new JPanel(), "blank");
            content.add(colorPane, "colorPane");
            content.add(numberPane, "numberPane");

            add(content);

            JPanel panel = new JPanel();
            JButton rndColor = new JButton("Color");
            rndColor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ColorWorker colorWorker = new ColorWorker(colorPane);
                    colorWorker.execute();
                    cardLayout.show(content, "colorPane");
                }
            });
            JButton rndNumber = new JButton("Number");
            rndNumber.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    NumberWorker numberWorker = new NumberWorker(numberPane);
                    numberWorker.execute();
                    cardLayout.show(content, "numberPane");
                }
            });
            panel.add(rndColor);
            panel.add(rndNumber);

            add(panel, BorderLayout.SOUTH);
        }

        public class ColorPane extends JPanel {

            public ColorPane() {
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(100, 100);
            }

        }

        public class ColorWorker extends SwingWorker<Color, Color> {

            private ColorPane colorPane;

            public ColorWorker(ColorPane colorPane) {
                this.colorPane = colorPane;
            }

            @Override
            protected void process(List<Color> chunks) {
                colorPane.setBackground(chunks.get(chunks.size() - 1));
            }

            @Override
            protected Color doInBackground() throws Exception {
                int randomColors = 1 + (int) (Math.random() * 100);
                Color color = null;
                for (int index = 0; index < randomColors; index++) {
                    int red = (int) (Math.random() * 255);
                    int green = (int) (Math.random() * 255);
                    int blue = (int) (Math.random() * 255);
                    color = new Color(red, green, blue);
                    publish(color);
                    Thread.sleep(40);
                }
                System.out.println(color);
                return color;
            }

            @Override
            protected void done() {
                try {
                    Color color = get();
                    colorPane.setBackground(color);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                } catch (ExecutionException ex) {
                    ex.printStackTrace();
                }
            }

        }

        public class NumberPane extends JPanel {

            private JLabel label;

            public NumberPane() {
                setLayout(new GridBagLayout());
                label = new JLabel("...");
                add(label);
            }

            public void setNumber(int number) {
                label.setText(Integer.toString(number));
                revalidate();
                repaint();
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(100, 100);
            }

        }

        public class NumberWorker extends SwingWorker<Integer, Integer> {

            private NumberPane numberPane;

            public NumberWorker(NumberPane colorPane) {
                this.numberPane = colorPane;
            }

            @Override
            protected void process(List<Integer> chunks) {
                numberPane.setNumber(chunks.get(chunks.size() - 1));
            }

            @Override
            protected Integer doInBackground() throws Exception {
                int randomNumbers = (int) (Math.random() * 100);
                int number = 0;
                for (int index = 0; index < randomNumbers; index++) {
                    number = (int) (Math.random() * 1024);
                    publish(number);
                    Thread.sleep(40);
                }
                return number;
            }

            @Override
            protected void done() {
                try {
                    int number = get();
                    numberPane.setNumber(number);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                } catch (ExecutionException ex) {
                    ex.printStackTrace();
                }
            }

        }

    }

}