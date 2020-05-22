public PandemicModel (PandemicModel other){

    this.rows = other.rows;
    this.columns = other.columns;

    this.grid = new (Type)[this.rows][this.columns];

    for (int i=0; i<other.rows; i++){
        for (int j=0; j<other.columns; j++){
            this.grid[i][j] = other.grid[i][j];
        }
    }
}