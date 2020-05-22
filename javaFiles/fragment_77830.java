import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JAlienHunt extends JApplet implements ActionListener {

    private JButton button = new JButton();
    JLabel greeting = new JLabel("Welcome to Alien Hunt Game!");
    JLabel gameOverMessage = new JLabel(" ");
    JPanel displayPanel = new JPanel(new GridLayout(2, 4));
    private int[] alienArray = new int[8];
    int countJ = 0, countM = 0;
    private ImageIcon image = new ImageIcon("earth.jpg");
    private int width, height;
    Container con = getContentPane();
    Font aFont = new Font("Gigi", Font.BOLD, 20);

    public void init() {

        /**
         * Setting the Layout and adding the content.
         */
        width = image.getIconWidth();
        height = image.getIconHeight();

        greeting.setFont(aFont);
        greeting.setHorizontalAlignment(SwingConstants.CENTER);
        con.setLayout(new BorderLayout());
        con.add(greeting, BorderLayout.NORTH);
        con.add(displayPanel, BorderLayout.CENTER);



        /**
         * Add Buttons to the Applet
         */
        displayPanel.add(button);
//        String text = Integer.toString(i + 1);     // convert button # to String adding 1.
        button.setText("!");
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {

        /**
         * Shows the Alien representing the selected button and deactivate the
         * button.
         */
//        if (event.getSource() == buttons) {
//            button.setText("Jupiterian");
//        } else {
////            buttons[i].setText("Martian");
//        }

        button.setEnabled(false);
        con.remove(greeting);
        displayPanel.remove(button);
        displayPanel.setLayout(new FlowLayout());
        gameOverMessage.setHorizontalAlignment(SwingConstants.CENTER);
        con.add(gameOverMessage, BorderLayout.NORTH);
        displayPanel.setBackground(Color.BLACK);
        gameOverMessage.setFont(new Font("Calibri", Font.BOLD, 25));
        gameOverMessage.setText("The Earth has been destroyed!");
        repaint();
    }

    public void paint(Graphics gr) {

        super.paint(gr);

        /**
         * Condition when user loses the game. Two Jupiterians will be painted on
         * the screen
         */
        Jupiterian jupit = new Jupiterian();
//        displayPanel.setBackground(Color.BLACK);
//        gameOverMessage.setFont(new Font("Calibri", Font.BOLD, 25));
//        gameOverMessage.setText("The Earth has been destroyed!");
        jupit.draw(gr, 250, 120);
//        gr.copyArea(190, 40, 465, 300, 500, 0);
        gr.drawImage(image.getImage(), 400, 400, width, height, this);  //+ 

    }

    public class Jupiterian {

        public void draw(Graphics g, int x, int y) {

            g.setColor(Color.WHITE);
            g.drawOval(x, y, 160, 160);                         // Body of the alien
            g.drawLine(x, y + 80, x - 40, y + 170);             // Left hand
            g.drawLine(x - 40, y + 170, x - 40, y + 180);       // Left hand fingers
            g.drawLine(x - 40, y + 170, x - 55, y + 180);
            Font aFont = new Font("Chiller", Font.BOLD, 30);  // Description text.
            g.setFont(aFont);
            g.drawString(toString(), 230, 60);
        }
    }
}