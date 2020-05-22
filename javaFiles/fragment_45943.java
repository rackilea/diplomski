import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Game {

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
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

        private List<String> characters = new ArrayList<>(Arrays.asList(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}));
        private List<JButton> buttons;
        private List<Color> colors = new ArrayList<>(Arrays.asList(new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW}));

        private Map<String, JButton> characterToButton = new HashMap<>(25);
        private Map<Color, List<JButton>> colorToButtons = new HashMap<>(25);

        public TestPane() {
            setLayout(new GridLayout(4, 4));

            List<Integer> indicies = new ArrayList<>(4 * 4);
            buttons = new ArrayList<>(25);
            for (int index = 0; index < 4 * 4; index++) {
                Collections.shuffle(colors);
                Color color = colors.get(0);
                indicies.add(index);
                JButton btn = new JButton();
                buttons.add(btn);
                btn.setBackground(color);
                add(btn);

                List<JButton> btns = colorToButtons.get(color);
                if (btns == null) {
                    btns = new ArrayList<>(25);
                    colorToButtons.put(color, btns);
                }
                btns.add(btn);
            }

            Collections.shuffle(characters);
            Collections.shuffle(indicies);
            List<Color> usedColor = new ArrayList<>(4);
            for (int index = 0; index < 4; index++) {
                String value = characters.get(index);
                JButton btn = null;
                do {
                    int buttonIndex = indicies.remove(0);
                    btn = buttons.get(buttonIndex);
                } while (usedColor.contains(btn.getBackground()));
                usedColor.add(btn.getBackground());
                btn.setText(value);
                characterToButton.put(value, btn);
                addKeyBinding(btn, value);
            }
        }

        protected void addKeyBinding(JComponent comp, String value) {
            InputMap inputMap = comp.getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = comp.getActionMap();

            inputMap.put(KeyStroke.getKeyStroke("typed " + value.toLowerCase()), value);
            actionMap.put(value, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton btn = characterToButton.get(value);
                    Color color = btn.getBackground();
                    for (JButton others : colorToButtons.get(color)) {
                        others.setEnabled(false);
                    }
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

}