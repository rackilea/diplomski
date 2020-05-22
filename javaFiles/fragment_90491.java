public class ArrayCombine {
    String[][] input;
    String[][] output;

    public ArrayCombine(String[][] input) {
        this.input = input;
    }

    public String[][] combineColumns() {
        if (output == null) {
            output = new String[input.length][];
            for (int i = 0; i < input.length; i++) {
                RowCombine rowCombine = new RowCombine(input[i]);
                output[i] = rowCombine.combine();
            }
        }
        return output;
    }

    public void print() {
        combineColumns();
        for (String[] row : output) {
            for (String value : row) {
                System.out.print(value + ' ');
            }
            System.out.println();
        }
    }
}