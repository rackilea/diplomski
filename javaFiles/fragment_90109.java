@SuppressWarnings("serial")
public class MoveAction extends AbstractAction {
    Direction direction;

    public MoveAction(Direction direction) {
        // this is the only code the constructor should have!
        this.direction = direction;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // use direction to help make move in here
    }
}