import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class Clock {

    private JFrame frame;
    private JLabel label;
    private ClockDisplay clock;
    private boolean clockRunning = false;
    private TimerThread timerThread;

    public static void main(String[] args) {
        System.out.println((13 % 13));
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Clock();
            }
        });
    }

    /**
     * Constructor for objects of class Clock
     */
    public Clock() {
        makeFrame();
        clock = new ClockDisplay(12, 0);
    }

    /**
     *
     */
    private void start() {
        clockRunning = true;
        timerThread = new TimerThread();
        timerThread.start();
    }

    /**
     *
     */
    private void stop() {
        clockRunning = false;
    }

    /**
     *
     */
    private void step() {
        clock.timeTick();
        label.setText(clock.getTime());
    }

    /**
     * 'About' function: show the 'about' box.
     */
    private void showAbout() {
        JOptionPane.showMessageDialog(frame,
                "Clock Version 1.0\n"
                + "A simple interface for the 'Objects First' clock display project",
                "About Clock",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Quit function: quit the application.
     */
    private void quit() {
        System.exit(0);
    }

    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame() {
        frame = new JFrame("Clock");
        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.setBorder(new EmptyBorder(1, 60, 1, 60));

        makeMenuBar(frame);

        // Specify the layout manager with nice spacing
        contentPane.setLayout(new BorderLayout(12, 12));

        // Create the image pane in the center
        label = new JLabel("12:00", SwingConstants.CENTER);
        Font displayFont = label.getFont().deriveFont(96.0f);
        label.setFont(displayFont);
        //imagePanel.setBorder(new EtchedBorder());
        contentPane.add(label, BorderLayout.CENTER);

        // Create the toolbar with the buttons
        JPanel toolbar = new JPanel();
        toolbar.setLayout(new GridLayout(1, 0));

        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> start());
        toolbar.add(startButton);

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(e -> stop());
        toolbar.add(stopButton);

        JButton stepButton = new JButton("Step");
        stepButton.addActionListener(e -> step());
        toolbar.add(stepButton);

        // Add toolbar into panel with flow layout for spacing
        JPanel flow = new JPanel();
        flow.add(toolbar);

        contentPane.add(flow, BorderLayout.SOUTH);

        // building is done - arrange the components      
        frame.pack();

        // place the frame at the center of the screen and show
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width / 2 - frame.getWidth() / 2, d.height / 2 - frame.getHeight() / 2);
        frame.setVisible(true);
    }

    /**
     * Create the main frame's menu bar.
     *
     * @param frame The frame that the menu bar should be added to.
     */
    private void makeMenuBar(JFrame frame) {
        final int SHORTCUT_MASK
                = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        JMenu menu;
        JMenuItem item;

        // create the File menu
        menu = new JMenu("File");
        menubar.add(menu);

        item = new JMenuItem("About Clock...");
        item.addActionListener(e -> showAbout());
        menu.add(item);

        menu.addSeparator();

        item = new JMenuItem("Quit");
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
        item.addActionListener(e -> quit());
        menu.add(item);
    }

    class TimerThread extends Thread {

        public void run() {
            while (clockRunning) {
                step();
                pause();
            }
        }

        private void pause() {
            try {
                Thread.sleep(300);   // pause for 300 milliseconds
            } catch (InterruptedException exc) {
            }
        }
    }

    public class NumberDisplay {

        private int minimum = 1;
        private int maximum = 13;
        private int value;

        /**
         * Constructor for objects of class NumberDisplay. Set the limit at
         * which the display rolls over.
         */
        public NumberDisplay(int maxumum, int minimum) {
            this.maximum = maxumum;
            this.minimum = minimum;
            value = 1;
        }

        /*
     * 
         */
        /**
         * Return the current value.
         */
        public int getValue() {
            return value;
        }

        /**
         * Return the display value (that is, the current value as a two-digit
         * String. If the value is less than ten, it will be padded with a
         * leading zero).
         */
        public String getDisplayValue() {
            if (value < 10) {
                return "0" + value; // stay 0 appears in left 
            } else {
                return "" + value; // none to show in right of the display
            }
        }

        /**
         * Set the value of the display to the new specified value. If the new
         * value is less than zero or over the limit, do nothing.
         */
        public boolean setValue(int replacementValue) {
            if (replacementValue >= maximum) {
                value = minimum;
                return true;
            } else {
                value = replacementValue;
                return false;
            }
        }

        /**
         * Increment the display value by one, rolling over to zero if the limit
         * is reached.
         */
        public boolean increment() {
//            value = (value + 1) % maximum; // this is already the time by 1 
            return setValue(value + 1);
        }
    }

    public class ClockDisplay {

        private NumberDisplay hours;    // runs from 1 am/pm to 11:59 am/pm
        private NumberDisplay minutes;  // This will running like 
        //  seconds act as minutes.
        private String displayString;    // simulates the actual display

        /**
         * Constructor for ClockDisplay objects. This constructor creates a new
         * clock set at 00:00.
         */
        public ClockDisplay() {
            hours = new NumberDisplay(13, 1); // set great than 13; runs from 1am to 12 noon
            minutes = new NumberDisplay(60, 0); // 60 minutes is one hour
            updateDisplay();
        }

        /**
         * Constructor for ClockDisplay objects. This constructor creates a new
         * clock set at the time specified by the parameters.
         */
        public ClockDisplay(int hour, int minute) {
            this();
            setTime(hour, minute);
        }

        /**
         * This method should get called once every minute - it makes the clock
         * display go one minute forward.
         */
        public void timeTick() {
            if (minutes.increment()) {  // on clock at after 12 am or pm.
                hours.increment(); // after 60 mins, next per hour.
            }
            updateDisplay(); // updating to return 
        }

        /**
         * Set the time of the display to the specified hour and minute.
         */
        public void setTime(int hour, int minute) {
            System.out.println("setTime " + hour + ":" + minute);
            hours.setValue(hour);       // hours will be set on display
            minutes.setValue(minute);   // minutes will be set on display
            updateDisplay();            // updating the value to display
        }

        /**
         * Return the current time of this display in the format HH:MM.
         */
        public String getTime() {
            return displayString; // appears as messagebox to display the clock
        }

        /**
         * Update the internal string that represents the display.
         */
        private void updateDisplay() {
            displayString = hours.getDisplayValue() + ":"
                    + minutes.getDisplayValue(); //Updated the clock simulator 
        }
    }
}