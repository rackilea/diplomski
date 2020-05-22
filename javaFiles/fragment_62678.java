public static Pane makeGrid(int n){

    double width = GridMaker.SCREEN_SIZE/n;
    Pane p = new Pane();

    Rectangle [][] rec = new Rectangle [n][n];

    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            rec[i][j] = new Rectangle();
            rec[i][j].setX(i * width);
            rec[i][j].setY(j * width);
            rec[i][j].setWidth(width);
            rec[i][j].setHeight(width);
            rec[i][j].setFill(null);
            rec[i][j].setStroke(Color.BLACK);
            p.getChildren().add(rec[i][j]);

        }
    }

    return p;
}