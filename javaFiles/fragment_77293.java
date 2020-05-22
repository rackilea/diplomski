import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LotteryInterface extends JPanel {

    LotteryEvent hello = new LotteryEvent(this);

    //set up row 1 
    JPanel row1 = new JPanel();
    ButtonGroup option = new ButtonGroup();
    JCheckBox quickpick = new JCheckBox("Quick Pick", false);
    JCheckBox personal = new JCheckBox("Personal", true);
    //set up row 2 
    JPanel row2 = new JPanel();
    JLabel numbersLabel = new JLabel("Your Picks", JLabel.RIGHT);
    JTextField[] numbers = new JTextField[6];
    JLabel winnersLabel = new JLabel("Winners", JLabel.RIGHT);
    JTextField[] winners = new JTextField[6];
    //set up row 3
    JPanel row3 = new JPanel();
    JButton play = new JButton("Play");
    JButton stop = new JButton("Stop");
    JButton reset = new JButton("Reset");
    //set up row 4
    JPanel row4 = new JPanel();
    JLabel got3label = new JLabel("3 of 6", JLabel.RIGHT);
    JTextField got3 = new JTextField("0");
    JLabel got4Label = new JLabel("4 of 6", JLabel.RIGHT);
    JTextField got4 = new JTextField("0");
    JLabel got5label = new JLabel("5 of 6", JLabel.RIGHT);
    JTextField got5 = new JTextField("0");
    JLabel got6label = new JLabel("6 of 6", JLabel.RIGHT);
    JTextField got6 = new JTextField("0", 10);
    JLabel drawingsLabel = new JLabel("Drawings", JLabel.RIGHT);
    JTextField drawings = new JTextField();
    JLabel yearsLabel = new JLabel("Years", JLabel.RIGHT);
    JTextField years = new JTextField();

    public LotteryInterface() {
        GridLayout layout = new GridLayout(0, 1, 10, 10);
        setLayout(layout);

        ItemListener itemListener = new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                Object item = e.getItem();
                if (item == quickpick) {
                    for (int i = 0; i < 6; i++) {
                        int pick;
                        do {
                            pick = (int) Math.floor(Math.random() * 50 + 1);

                        } while (numberGone(pick, numbers, i));
                        numbers[i].setText("" + pick);
                    }
                } else {

                    for (int i = 0; i < 6; i++) {
                        numbers[i].setText(null);
                    }
                }

            }
        };

        personal.addItemListener(itemListener);
        quickpick.addItemListener(itemListener);
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hello.start();
            }
        });
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hello.stop();
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hello.stop();
                clearAllFields();
            }
        });

        FlowLayout layout1 = new FlowLayout(FlowLayout.CENTER, 10, 10);
        option.add(quickpick);
        option.add(personal);
        row1.setLayout(layout1);
        row1.add(quickpick);
        row1.add(personal);
        add(row1);

        GridLayout layout2 = new GridLayout(2, 7, 10, 10);
        row2.setLayout(layout2);
        row2.add(numbersLabel);
        for (int i = 0; i < 6; i++) {
            numbers[i] = new JTextField();
            row2.add(numbers[i]);
        }
        row2.add(winnersLabel);
        for (int i = 0; i < 6; i++) {
            winners[i] = new JTextField();
            winners[i].setEditable(false);
            row2.add(winners[i]);
        }
        add(row2);

        FlowLayout layout3 = new FlowLayout(FlowLayout.CENTER, 10, 10);
        row3.setLayout(layout3);
        row3.add(stop);
        row3.add(play);
        row3.add(reset);
        add(row3);

        GridLayout layout4 = new GridLayout(2, 3, 20, 10);
        row4.setLayout(layout4);
        row4.add(got3label);
        got3.setEditable(false);
        row4.add(got3);
        row4.add(got4Label);
        got4.setEditable(false);
        row4.add(got4);
        row4.add(got5label);
        got5.setEditable(false);
        row4.add(got5);
        row4.add(got6label);
        got6.setEditable(false);
        row4.add(got6);
        row4.add(drawingsLabel);
        drawings.setEditable(false);
        row4.add(drawings);
        row4.add(yearsLabel);
        years.setEditable(false);
        row4.add(years);
        add(row4);

    }

    void clearAllFields() {
        for (int i = 0; i < 6; i++) {
            winners[i].setText(null);
            numbers[i].setText(null);
        }

        got3.setText("0");
        got4.setText("0");
        got4.setText("0");
        got5.setText("0");
        got6.setText("0");

        years = null;
        drawings = null;

    }

    boolean numberGone(int nums, JTextField[] pastNums, int count) {
        for (int i = 0; i < count; i++) {
            if (Integer.parseInt(pastNums[i].getText()) == nums) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {

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
                frame.add(new LotteryInterface());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class LotteryEvent {

        LotteryInterface gui;
        private Timer timer;

        public LotteryEvent(LotteryInterface in) {
            gui = in;
            timer = new Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addOneToField(gui.drawings);
                    int draw = Integer.parseInt(gui.drawings.getText());
                    float numYears = (float) draw / 104;
                    gui.years.setText("" + numYears);

                    int matches = 0;
                    for (int i = 0; i < 6; i++) {
                        int ball;
                        do {
                            ball = (int) Math.floor(Math.random() * 50 + 1);
                        } while (numberGone(ball, gui.winners, i));
                        gui.winners[i].setText("" + ball);
                        if (matchedOne(gui.winners[i], gui.numbers)) {
                            matches++;
                        }

                    }
                    switch (matches) {
                        case 3:
                            addOneToField(gui.got3);
                            break;
                        case 4:
                            addOneToField(gui.got4);
                            break;
                        case 5:
                            addOneToField(gui.got5);
                            break;
                        case 6:
                            addOneToField(gui.got6);
                            gui.stop.setEnabled(false);
                            gui.play.setEnabled(true);
                            stop();
                    }
                }
            });
        }

        public void stop() {
            timer.stop();
        }

        public void start() {
            timer.start();
        }

        void addOneToField(JTextField field) {
            int num = Integer.parseInt("0" + field.getText());
            num++;
            field.setText("" + num);
        }

        boolean matchedOne(JTextField win, JTextField[] allpicks) {
            for (int i = 0; i < 6; i++) {
                String winText = win.getText();
                if (winText.equals(allpicks[i].getText())) {
                    return true;
                }
            }
            return false;
        }

    }

}