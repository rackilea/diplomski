public class World<T>
{
    private Grid<T> gr;
    private Set<String> occupantClassNames;
    private Set<String> gridClassNames;
    private String message;
    private JFrame frame;

    private static Random generator = new Random();

    private static final int DEFAULT_ROWS = 10;
    private static final int DEFAULT_COLS = 10;
    ...
}