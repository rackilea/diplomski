class Matrix {
    private int[][] values;

    public Matrix(int[][] values) {
        this.values = values;
    }

    public int[][] getValues() {
        return values;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matrix [values=\n");
        for (int i = 0; i < values.length; i++) {
            sb.append("\t" +  Arrays.toString(values[i]) + "\n");
        }
        sb.append("]");
        return sb.toString();
    }
}