public void setField(int [][] field){
    this.field = field;
}

public int[][] getField() {
    return field;
}

//Change the element of the field
public void setElement (int i, int j, int n) {
    field[i][j] = n;
}