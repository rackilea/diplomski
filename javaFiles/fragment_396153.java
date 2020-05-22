@FXML private AnchorPane grid;
@FXML private Slider heightSlider;
@FXML private Slider widthSlider;
@FXML private Label heightLbl;
@FXML private Label widthLabel;
@FXML private Button robotBtn;

private int space = 1; // space between each rectangle
private ArrayList<Shape> shapes = new ArrayList<>(25); //Keeps track of the rectangles we currently have on-screen

@FXML public void initialize(){
        heightSlider.valueProperty().addListener((observarable, oldValue, newValue) -> {
            heightLbl.setText(Double.toString(heightSlider.getValue()));
            drawGrid(widthSlider.getValue(), heightSlider.getValue()); // Redraw the grid with the new dimensions
        });
        widthSlider.valueProperty().addListener((observarable1, oldValue1, newValue1) -> {
            widthLabel.setText(Double.toString(widthSlider.getValue()));
            drawGrid(widthSlider.getValue(), heightSlider.getValue()); // Redraw the grid with the new dimensions
        });
}

private void drawGrid(double width, double height){ // Draw grid with the provided dimensions
    if(shapes.size() > 0)
        grid.getChildren().removeAll(shapes);       // We must remove the previous rectangles, not just draw new ones (memory leak, performance)
    shapes.clear();
    for(int i = 0; i < (int) height; i++){ // columns
        for(int j = 0; j < (int) width; j++){ // rows
            Rectangle rectangle = new Rectangle(space+i*35, space+j*35, 35-2*space, 35-2*space);
            rectangle.setFill(Color.WHITE); // rectangle color
            rectangle.setStroke(Color.GREY); // outline color
            shapes.add(rectangle);
            grid.getChildren().add(rectangle);
        }
    }
}