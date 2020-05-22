public final class MyClass<T> {

    public MyClass(Function<Number, Function<Number, T>> func, Number rows, Number cols) {
        super(result(func, rows, cols));
    }

    private static <Z> Z[][] result(Function<Number, Function<Number, Z>> func, Number rows, Number cols) {
        final Z[][] result = (Z[][]) new Object[rows.intValue()][cols.intValue()];
        for (int row = 0; row < rows.intValue(); ++row) {
            for(int col = 0; col < cols.intValue(); ++col) {
                result[row][col] = func.apply(row).apply(col);
            }
        }
        return result;
    }

}