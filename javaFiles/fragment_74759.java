import java.beans.PropertyChangeListener;
import javax.swing.event.SwingPropertyChangeSupport;

public class MatrixModel {
    public static final String SPRITE_POINT = "sprite point";
    private SwingPropertyChangeSupport pcSupport = new SwingPropertyChangeSupport(this);
    private MatrixPosition[][] grid;
    private SpritePosition spritePosition;

    public MatrixModel(MatrixPosition[][] grid, SpritePosition spritePosition) {
        this.grid = grid;
        this.spritePosition = spritePosition;
    }

    public int getRows() {
        return grid.length;
    }

    public int getColumns() {
        return grid[0].length;
    }

    public MatrixPosition getPosition(SpritePosition p) {
        return getPosition(p.row, p.column);
    }

    public MatrixPosition getPosition(int row, int col) {
        return grid[row][col];
    }

    public void setSpritePoint(SpritePosition spritePosition) {
        SpritePosition oldValue = this.spritePosition;
        SpritePosition newValue = spritePosition;
        this.spritePosition = spritePosition;
        pcSupport.firePropertyChange(SPRITE_POINT, oldValue, newValue);
    }

    public boolean isPointValid(SpritePosition p) {
        if (p.column < 0 || p.row < 0) {
            return false;
        }
        if (p.column >= grid[0].length || p.row >= grid.length) {
            return false;
        }
        return grid[p.row][p.column] == MatrixPosition.CORRIDOR;
    }

    public boolean isMoveValid(Direction direction) {
        int row = spritePosition.row;
        int column = spritePosition.column;
        switch (direction) {
        case UP:
            return isPointValid(new SpritePosition(row - 1, column));
        case DOWN:
            return isPointValid(new SpritePosition(row + 1, column));
        case LEFT:
            return isPointValid(new SpritePosition(row, column - 1));
        case RIGHT:
            return isPointValid(new SpritePosition(row, column + 1));
        default:
            return false;
        }
    }

    public void move(Direction direction) {
        if (!isMoveValid(direction)) {
            String text = "For move to " + direction + "spritePosition: " + spritePosition;
            throw new IllegalArgumentException(text);
        }
        int row = spritePosition.row;
        int column = spritePosition.column;
        switch (direction) {
        case UP:
            setSpritePoint(new SpritePosition(row - 1, column));
            break;
        case DOWN:
            setSpritePoint(new SpritePosition(row + 1, column));
            break;
        case LEFT:
            setSpritePoint(new SpritePosition(row, column - 1));
            break;
        case RIGHT:
            setSpritePoint(new SpritePosition(row, column + 1));
            break;

        default:
            break;
        }
    }

    public SpritePosition getSpritePosition() {
        return spritePosition;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcSupport.removePropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        pcSupport.addPropertyChangeListener(name, listener);
    }

    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        pcSupport.removePropertyChangeListener(name, listener);
    }
}