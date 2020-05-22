import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.EnumMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class Controller {
    private MatrixModel model;
    private View view;
    private Map<Direction, KeyStroke> dirKeyMap = new EnumMap<>(Direction.class);

    public Controller(MatrixModel model, View view) {
        this.model = model;
        this.view = view;

        dirKeyMap.put(Direction.DOWN, KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0));
        dirKeyMap.put(Direction.UP, KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0));
        dirKeyMap.put(Direction.LEFT, KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0));
        dirKeyMap.put(Direction.RIGHT, KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0));

        model.addPropertyChangeListener(new ModelListener());
        setUpKeyBindings(view);
    }

    private void setUpKeyBindings(View view) {
        int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
        InputMap inputMap = view.getInputMap(condition);
        ActionMap actionMap = view.getActionMap();
        for (Direction dir : Direction.values()) {
            KeyStroke keyStroke = dirKeyMap.get(dir);
            hookUp(inputMap, actionMap, dir, keyStroke);
        }
    }

    private void hookUp(InputMap inputMap, ActionMap actionMap, Direction dir, KeyStroke key) {
        inputMap.put(key, key.toString());
        actionMap.put(key.toString(), new MoveAction(dir, model));
    }

    public MatrixModel getModel() {
        return model;
    }

    public View getView() {
        return view;
    }

    class ModelListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (MatrixModel.SPRITE_POINT.equals(evt.getPropertyName())) {
                SpritePosition p = model.getSpritePosition();
                view.setSpritePoint(p);
            }
        }
    }

}

@SuppressWarnings("serial")
class MoveAction extends AbstractAction {
    private Direction dir;
    private MatrixModel model;

    public MoveAction(Direction dir, MatrixModel model) {
        super(dir.toString());
        this.dir = dir;
        this.model = model;
    }

    public void actionPerformed(ActionEvent e) {
        if (model.isMoveValid(dir)) {
            model.move(dir);
        }
    }
}