import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

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
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice gd = ge.getDefaultScreenDevice();

                Login login = new Login();
                JFrame frame = new JFrame("Project Zenith");
                frame.setUndecorated(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(login);
                frame.pack();
                frame.setLocationRelativeTo(null);
//              gd.setFullScreenWindow(frame);
                frame.setVisible(true);
            }
        });
    }

    public static class Master extends JPanel {

        private static final long serialVersionUID = -4927941474660261348L;

        private Rectangle closeRect;

        public Master() {

            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getX() >= closeRect.getX() && e.getY() <= closeRect.getHeight()) {
                        closeClicked();
                    }
                }

                @Override
                public void mouseEntered(MouseEvent arg0) {

                }

                @Override
                public void mouseExited(MouseEvent arg0) {

                }

                @Override
                public void mousePressed(MouseEvent arg0) {

                }

                @Override
                public void mouseReleased(MouseEvent arg0) {

                }
            });
        }

        @Override
        public void invalidate() {
            super.invalidate();
            closeRect = new Rectangle(getWidth() - 35, 0, 35, 35);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2d.setColor(new Color(168, 168, 168, 200));
            FontMetrics fm = g2d.getFontMetrics();
            int y = (getHeight() - fm.getHeight()) + fm.getAscent();
            g2d.drawString("Project Zenith", 10, y);
            g2d.setColor(new Color(0xFFA6A6));
            g2d.fill(closeRect);
        }

        public void closeClicked() {
            System.exit(0);
        }
    }

    public static class Login extends Master {

        private static final long serialVersionUID = 1L;
        private JTextField username;
        private JTextField password;


        Login() {
            Font inputFont = new Font("Calibri", Font.PLAIN, 15);

            setLayout(new GridBagLayout());

            JPanel content = new JPanel(new GridBagLayout()) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    RoundRectangle2D loginRect = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setColor(Color.WHITE);
                    g2d.fill(loginRect);
                    g2d.setColor(new Color(0xA8A8A8));
                    g2d.draw(loginRect);
                }
            };
            content.setBorder(new EmptyBorder(20, 20, 20, 20));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.insets = new Insets(0, 0, 25, 0);

            gbc.gridx = 0;
            gbc.gridy = 0;

            JLabel label = new JLabel("Access Terminal");
            label.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
            label.setForeground(new Color(0xA8A8A8));

            content.add(label, gbc);

            gbc.gridy++;
            username = new JTextField(25);
            username.setFont(inputFont);
            username.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            username.setEditable(true);
            username.setBackground(new Color(0xE6E6E6));
            //username.setVisible(true);
            content.add(username, gbc);

            gbc.gridy++;
            password = new JPasswordField(25);
            password.setFont(inputFont);
            password.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            password.setEditable(true);
            password.setBackground(new Color(0xE6E6E6));
            //password.setVisible(true);
            content.add(password, gbc);

            gbc.gridy++;

            JButton loginButton = new JButton("Login");
            loginButton.setFont(inputFont);
            loginButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            loginButton.setBackground(new Color(0xE6E6E6));
            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println(username.getText());
                }
            });
            content.add(loginButton, gbc);

            add(content);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }
    }
}