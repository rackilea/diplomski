import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class StakeMeServer {

    private ServerSocket socket;
    private Thread t;
    private AtomicBoolean online = new AtomicBoolean(false);

    public static void main(String[] args) throws IOException {
        new StakeMeServer();
    }

    public StakeMeServer() {

        SwingUtilities.invokeLater(new Runnable() {
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
        });

        open();

        Thread t = new Thread(() -> {
            System.out.println("1");
            while (online.get()) {
                System.out.println("2");
            }
        });
        t.setDaemon(true);
        t.setName("GameServer");
        t.start();
    }

    public void open() {
        System.out.println("Starting Server...");
        online.set(true);
        System.out.println("Server Online");
    }

    public void close() {
        System.out.println("Stopping Server...");
        online.set(false);
        System.out.println("Server Offline");
    }

    public class TestPane extends JPanel {

        private int x = 0;
        private int delta = 4;

        private JLabel state;

        public TestPane() {
            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    x += delta;
                    if (x + 10 > getWidth()) {
                        x = getWidth() - 10;
                        delta *= -1;
                    } else if (x < 0) {
                        x = 0;
                        delta *= -1;
                    }
                    state.setText(Boolean.toString(online.get()));
                    repaint();
                }
            });
            timer.start();

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            state = new JLabel(Boolean.toString(online.get()));
            add(state, gbc);

            JButton btn = new JButton("Stop");
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btn.setEnabled(false);
                    close();
                }
            });
            add(btn, gbc);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.RED);
            g2d.fillOval(x, (getHeight() / 2) - 5, 10, 10);
            g2d.dispose();
        }

    }

}