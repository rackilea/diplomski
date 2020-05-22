import java.awt.AWTKeyStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Game {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                new Game();
            }
        });
    }

    private Model model;

    public Game() {
        model = new Model();
        model.add(new Tile(Tile.randomLetter(), Color.WHITE));
        model.add(new Tile(Tile.randomLetter(), Color.RED));
        model.add(new Tile(Tile.randomLetter(), Color.GREEN));
        model.add(new Tile(Tile.randomLetter(), Color.YELLOW));

        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new GridLayout(4, 1));
        frame.setSize(500, 800);
        frame.setVisible(true);

        for (Tile tile : model.getTiles()) {
            frame.add(tile);
            KeyStroke ks = KeyStroke.getKeyStroke(tile.getChar());
            String name = "typed." + tile.getChar();
            Action action = new TileAction(model, tile.getChar());

            registerKeyBinding((JComponent)frame.getContentPane(), name, ks, action);
        }

        model.addModelListener(new ModelListener() {
            @Override
            public void tileWasRemoved(Tile tile) {
                frame.remove(tile);
                frame.revalidate();
                frame.repaint();
            }
        });
    }

    public void registerKeyBinding(JComponent parent, String name, KeyStroke ks, Action action) {
        InputMap im = parent.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = parent.getActionMap();

        im.put(ks, name);
        am.put(name, action);
    }

    public class TileAction extends AbstractAction {

        private Model model;
        private char value;

        public TileAction(Model model, char value) {
            this.model = model;
            this.value = value;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            model.removeByChar(value);
        }

    }

    public interface ModelListener {

        public void tileWasRemoved(Tile tile);
    }

    public class Model {

        private ArrayList<Tile> list = new ArrayList<Tile>();
        private List<ModelListener> listeners = new ArrayList<>(25);

        public Model() {
        }

        public void addModelListener(ModelListener listener) {
            listeners.add(listener);
        }

        public void removeModelListener(ModelListener listener) {
            listeners.remove(listener);
        }

        protected void fireTileRemoved(Tile tile) {
            for (ModelListener listener : listeners) {
                listener.tileWasRemoved(tile);
            }
        }

        public void removeByChar(char value) {
            Iterator<Tile> iterator = list.iterator();
            while (iterator.hasNext()) {
                Tile tile = iterator.next();
                if (value == tile.getChar()) {
                    fireTileRemoved(tile);
                    iterator.remove();
                }
            }
        }

        private void add(Tile tile) {
            list.add(tile);
        }

        private Iterable<Tile> getTiles() {
            return Collections.unmodifiableList(list);
        }
    }

    public static class Tile extends JLabel {

        public static Font font = new Font("Serif", Font.BOLD, 39);

        private char _c;

        public Tile(char c, Color background) {
            setBackground(background);
            setOpaque(true);
            _c = c;
            setText(convert());

        }

        public static char randomLetter() {
            Random r = new Random();
            char randomChar = (char) (97 + r.nextInt(25));
            return randomChar;
        }

        public char getChar() {
            return _c;
        }

        public String convert() {
            return String.valueOf(getChar());
        }
    }

}