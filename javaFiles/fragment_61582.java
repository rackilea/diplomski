public class Field<E> {
    ArrayList<ArrayList<E>> field;

    public Field(int rows, int cols) {
        field = new ArrayList<ArrayList<E>>(rows);
        for (int i = 0; i < rows; i++) {
            ArrayList<E> row  = new ArrayList<E>(cols);
            for (int j = 0; j < cols; j++) {
                row.add(null);
            }
            field.add(row);
        }
    }

    public static void main(String[] args) {
        Field<String> field = new Field<String>(10, 10);
    }

}