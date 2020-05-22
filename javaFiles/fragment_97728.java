import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestRepaint01 {

    public static void main(String[] args) {
        new TestRepaint01();
    }

    public TestRepaint01() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                MainFrame frame = new MainFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(200, 200);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class MainFrame extends javax.swing.JFrame implements ActionListener {

        ArrayList<Pocitadlo> poc;
        Random rnd;
        private JPanel body;

        /**
         * Creates new form frmMain
         */
        public MainFrame() {

            setLayout(new BorderLayout());

            poc = new ArrayList<Pocitadlo>();
            rnd = new Random();

            body = new JPanel(null);
            add(body);
            JButton btn = new JButton("Add");
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int val, x, y;

                    val = 20;
                    x = (getWidth() / 2) - 10 + rnd.nextInt(20);
                    y = (getHeight() / 2) - 10 + rnd.nextInt(20);

//                    try {
//                        val = Integer.parseInt(txtCounterValue.getText());

                        Pocitadlo tmp = new Pocitadlo(val, x, y, getFont());
                        tmp.addActionListener(MainFrame.this);
                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.gridwidth = GridBagConstraints.REMAINDER;
                        gbc.weightx = 1;
                        gbc.fill = GridBagConstraints.HORIZONTAL;
                        poc.add(tmp);
                        tmp.start();
                        body.add(tmp);
                        body.repaint();
                        setTitle("Počet počítadiel: " + getComponentCount());
//                    } catch (Exception e) {
//                        JOptionPane.showMessageDialog(this, "Nesprávne zadaná alebo prázdna hodnota počítadla. Hodnota musí byť     celé číslo.", "Chyba", JOptionPane.ERROR_MESSAGE);
//                    }
                }
            });
            add(btn, BorderLayout.SOUTH);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("counterFinished")) {
                System.out.println("Counter finished");
                Pocitadlo tmp = (Pocitadlo) e.getSource();

                poc.remove(tmp);
                this.setTitle("Počet počítadiel: " + poc.size());
                body.remove(tmp);
//                body.revalidate();
                body.repaint();
            }
        }

    }

    public class Pocitadlo extends JPanel implements MouseListener, ActionListener {

        private int maxValue, value;
        private Boolean isRunning, isDisplayed;
        private Timer valueTimer, blinkTimer;
        private ActionListener actionListener;
        private Font font;

        public Pocitadlo(int timeout, int x, int y, Font f) {
            isRunning = false;
            isDisplayed = true;
            maxValue = value = timeout;

            valueTimer = new Timer(1000, this);
            valueTimer.setActionCommand("valueTimer");

            blinkTimer = new Timer(200, this);
            blinkTimer.setActionCommand("blinkTimer");

            this.setBounds(x, y, 100, 50);
        }

        @Override
        public void removeNotify() {
            super.removeNotify();
            stop();
            blinkTimer.stop();
        }

        public void start() {
            isRunning = true;
            valueTimer.start();
        }

        public void stop() {
            isRunning = false;
            valueTimer.stop();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("valueTimer")) {
                value--;
                System.out.println("value = " + value);

                if (actionListener != null) {
                    repaint();
                    actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "counterTick"));
                }

                if (value == 0 && actionListener != null) {
                    isRunning = false;
                    valueTimer.stop();
                    actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "counterFinished"));
                    blinkTimer.stop();
                } else if (value < maxValue / 2 && !blinkTimer.isRunning()) {
                    blinkTimer.start();
                }
            }

            if (e.getActionCommand().equals("blinkTimer")) {
                System.out.println("Blink");
                isDisplayed = !isDisplayed;
                repaint();
            }
        }

        public void addActionListener(ActionListener listener) {
            actionListener = listener;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            value += 5000;
            if (value > maxValue) {
                value = maxValue;
            }
            repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }        

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.red);
            // location bad
            g.fillRect(0, 0, getWidth(), getHeight());
            if (isDisplayed) {
                g.setColor(Color.green);
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.black);
                //g.setFont(font);
                FontMetrics fm = g.getFontMetrics();
                g.drawString(value + "/" + maxValue, 0, fm.getAscent());
            }

            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

    }

}