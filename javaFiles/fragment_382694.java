import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.*;

/**
 * link: http://stackoverflow.com/questions/21867283/method-keeps-window-from-
 * closing
 * 
 * @author Pete
 * 
 */
@SuppressWarnings("serial")
public class SimonPanelTest extends JPanel {
    private static final String PRESSED = "pressed";
    private static final String RELEASED = "released";
    private static final int TIMER_DELAY = 1000;
    private static final int TIME_SLICES = 8;
    private Random random = new Random();
    private SimonPanel simonPanel = new SimonPanel();

    public SimonPanelTest() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton(new ShowRandomPatternAction()));

        setLayout(new BorderLayout());
        add(simonPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setKeyBindings(simonPanel, KeyEvent.VK_UP, MyColor.GREEN);
        setKeyBindings(simonPanel, KeyEvent.VK_RIGHT, MyColor.YELLOW);
        setKeyBindings(simonPanel, KeyEvent.VK_DOWN, MyColor.BLUE);
        setKeyBindings(simonPanel, KeyEvent.VK_LEFT, MyColor.RED);

        simonPanel.addPropertyChangeListener(SimonPanel.MY_COLOR, pce -> {
            System.out.println(pce.getNewValue());
        });
    }

    private void setKeyBindings(SimonPanel panel, int keyCode, MyColor myColor) {
        int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
        InputMap inMap = panel.getInputMap(condition);
        ActionMap actMap = panel.getActionMap();

        KeyStroke keyPressed = KeyStroke.getKeyStroke(keyCode, 0, false);
        KeyStroke keyReleased = KeyStroke.getKeyStroke(keyCode, 0, true);

        inMap.put(keyPressed, myColor.toString() + PRESSED);
        inMap.put(keyReleased, myColor.toString() + RELEASED);

        actMap.put(myColor.toString() + PRESSED, new MyKeyAction(panel, myColor, true));
        actMap.put(myColor.toString() + RELEASED, new MyKeyAction(panel, myColor, false));
    }

    private class ShowRandomPatternAction extends AbstractAction {
        private static final int MIN_RANDOM_COLORS = 5;
        private static final int MAX_RANDOM_COLORS = 10;

        public ShowRandomPatternAction() {
            super("Show Random Pattern");
            putValue(MNEMONIC_KEY, KeyEvent.VK_S);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            List<MyColor> colorList = new ArrayList<MyColor>();
            for (int i = 0; i < random.nextInt(MAX_RANDOM_COLORS - MIN_RANDOM_COLORS)
                    + MIN_RANDOM_COLORS; i++) {
                int colorIndex = random.nextInt(MyColor.values().length);
                MyColor myColor = MyColor.values()[colorIndex];
                colorList.add(myColor);
            }

            ActionListener timerListener = new TimerListener(simonPanel, colorList);
            Timer timer = new Timer(TIMER_DELAY / TIME_SLICES, timerListener);
            timer.start();
        }
    }

    private class TimerListener implements ActionListener {
        @SuppressWarnings("hiding")
        private SimonPanel simonPanel;
        private int colorListIndex = 0;
        private int sliceCount = 0;
        private List<MyColor> myColorList;
        private int maxCount;

        public TimerListener(SimonPanel simonPanel, List<MyColor> myColorList) {

            this.simonPanel = simonPanel;
            this.myColorList = myColorList;
            maxCount = myColorList.size();
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            if (colorListIndex == maxCount) {
                for (MyColor myColor : MyColor.values()) {
                    simonPanel.setMyColorPressed(myColor, false);
                }
                ((Timer) evt.getSource()).stop();
                return;
            }

            if (sliceCount == 0) {
                MyColor myColor = myColorList.get(colorListIndex);
                simonPanel.setMyColorPressed(myColor, true);
                sliceCount++;
            } else if (sliceCount < TIME_SLICES - 1) {
                sliceCount++;
                return;
            } else if (sliceCount == TIME_SLICES - 1) {
                sliceCount = 0;
                MyColor myColor = myColorList.get(colorListIndex);
                simonPanel.setMyColorPressed(myColor, false);
                colorListIndex++;
                return;
            }
        }
    }

    private class MyKeyAction extends AbstractAction {
        private SimonPanel panel;
        private MyColor myColor;
        private boolean pressed;

        public MyKeyAction(SimonPanel panel, MyColor myColor, boolean pressed) {
            this.panel = panel;
            this.myColor = myColor;
            this.pressed = pressed;
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            panel.setMyColorPressed(myColor, pressed);
        }
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Simon Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new SimonPanelTest());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}