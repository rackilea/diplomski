enum CellType {

    OTHER(1, (x, y) -> true),
    TOP(2, (x, y) -> y == HEIGHT - 1),
    BOTTOM(2, (x, y) -> y == 0),
    LEFT(2, (x, y) -> x == 0),
    RIGHT(2, (x, y) -> x == WIDTH - 1),
    TOP_LEFT(3, TOP, LEFT),
    BOTTOM_RIGHT(3, BOTTOM, RIGHT),
    TOP_RIGHT(3, TOP, RIGHT),
    BOTTOM_LEFT(3, BOTTOM, LEFT);

    private static final int HEIGHT = 5;
    private static final int WIDTH = 5;

    private final int precedence;
    private final BiPredicate<Integer, Integer> test;

    private CellType(int precedence, BiPredicate<Integer, Integer> test) {
        this.precedence = precedence;
        this.test = test;
    }

    private CellType(int precedence, CellType type1, CellType type2) {
        this(precedence, type1.test.and(type2.test));
    }

    public static CellType valueOf(int x, int y) {
        assert x >= 0 && x < WIDTH && y >= 0 && y < WIDTH;
        return Arrays.stream(values())
            .filter(ct -> ct.test.test(x, y))
            .max(Comparator.comparingInt(ct -> ct.precedence))
            .orElse(OTHER);
    }
}