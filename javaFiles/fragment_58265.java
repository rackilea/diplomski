import java.beans.PropertyChangeListener;
import javax.swing.event.SwingPropertyChangeSupport;

public class Model {

    public static final int ROWS = 20;
    public static final int COLS = ROWS;
    public static final String TOKEN = "token";
    private Token[][] grid = new Token[ROWS][COLS];
    private SwingPropertyChangeSupport pcSupport = new SwingPropertyChangeSupport(this);

    //a stack representing cells in the path
    private Path path;

    public Model() {

        //set entire grid to  Token.VIDE
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                grid[r][c] = Token.VIDE;
            }
        }
    }

    Token getToken(int row, int col) {

        return grid[row][col];
    }

     void setToken(Token token, int row, int col) {

        Token oldValue = grid[row][col];
        Token newValue = token;
        grid[row][col] = token;
        int index = (row * grid[row].length) + col;
        pcSupport.fireIndexedPropertyChange(TOKEN, index, oldValue, newValue);

        findPath(new int[] {row, col});
    }

    void addPropertyChangeListener(String name, PropertyChangeListener listener) {

        pcSupport.addPropertyChangeListener(name, listener);
    }

    int getRows() {
        return ROWS;
    }

    int getCols() {
        return COLS;
    }

    //search for a path
    private void findPath(int[] origin) {

        //initialize path and checked
        path = new Path(grid);
        path.findPath(origin);
    }

    CellsList getPath() {

        return (path == null ) ? null : path.getPath();
    }
}