public void setField(int [][] field){
    this.field = Arrays.copyOf(field, field.length);
}

public int[][] getField() {
    return Arrays.copyOf(field, field.length);
}