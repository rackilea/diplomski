import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * @see https://stackoverflow.com/a/36243395/230513
 */
public class CardPanel extends JPanel {

    private static final JPanel cards = new JPanel(new CardLayout());
    private final String name;

    public CardPanel(String name) {
        super(new GridLayout(0, 1));
        this.name = name;
        JPanel top = new JPanel(new GridBagLayout());
        top.setBackground(Color.darkGray);
        JLabel label = new JLabel(name);
        label.setForeground(Color.yellow);
        top.add(label);
        JPanel bot = new JPanel();
        bot.setBorder(BorderFactory.createLineBorder(Color.yellow, 5));
        bot.add(new JRadioButton("A"));
        bot.add(new JRadioButton("B"));
        bot.add(new JRadioButton("C"));
        bot.add(new JRadioButton("D"));
        this.add(top);
        this.add(bot);
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                create();
            }
        });
    }

    private static void create() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 1; i < 9; i++) {
            CardPanel p = new CardPanel("Panel " + String.valueOf(i));
            cards.add(p, p.toString());
        }
        JPanel control = new JPanel();
        control.add(new JButton(new AbstractAction("\u22b2Prev") {

            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) cards.getLayout();
                cl.previous(cards);
            }
        }));
        control.add(new JButton(new AbstractAction("Next\u22b3") {

            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) cards.getLayout();
                cl.next(cards);
            }
        }));
        f.add(cards, BorderLayout.CENTER);
        f.add(control, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}