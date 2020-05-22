public class VisualizationThread implements EventHandler<ActionEvent> {

    private ArrayList<ArrayList<Integer>> matrix; // Matrix
    private ArrayList<Integer> solution; // One individual
    private ArrayList<ArrayList<Integer>> visited; // Visited coordinate list
    private int currentX; // Current x coordinate
    private int currentY; // Current y coordinate
    private int index; // Current movement index
    private int attempt; // unsuccessful attempt count (used while visualizing all generations)
    private boolean closeAtTheAnd; // Close all stages except the last one which shows final situation, the correct path
    private boolean isSuccessful; // Currently visualizing an unsuccessful attempt or correct path?
    private Stage primaryStage; // primary stage (gui component)

    public VisualizationThread(ArrayList<ArrayList<Integer>> matrix, ArrayList<Integer> solution, int currentX, int currentY,
                               boolean isSuccessful, int attempt, boolean closeAtTheAnd){
        this.matrix   = matrix;
        this.solution = solution;
        this.currentY = currentY;
        this.currentX = currentX;
        this.isSuccessful = isSuccessful;
        this.attempt = attempt;
        this.primaryStage = new Stage();
        this.index = 0;
        this.closeAtTheAnd = closeAtTheAnd;
        this.visited = new ArrayList<ArrayList<Integer>>();
    }

    // Visualize a single individual
    public void run() {

        // GUI processes
        BorderPane root = new BorderPane();

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        StackPane[][] screen_buttons = new StackPane[matrix.size()][matrix.size()];

        visited.add(new ArrayList<Integer>(){{add(currentX); add(currentY);}});
        for (int y=0;y<matrix.size();y++) {
            for (int x=0;x<matrix.get(y).size();x++) {
                screen_buttons[y][x] = new StackPane();
                Rectangle rec = new Rectangle(60,60);
                // Visualize visited points as green and others yellow and foods red
                if(!(currentX>=matrix.size() || currentY>=matrix.size())){
                    if(isVisited(visited, x, y)){
                        rec.setFill(Color.GREEN);
                    }else {
                        rec.setFill(matrix.get(y).get(x) == 0 ? Color.YELLOW : Color.RED);
                    }
                }else {
                    rec.setFill(matrix.get(y).get(x) == 0 ? Color.YELLOW : Color.RED);
                }

                rec.setStyle("-fx-arc-height: 20; -fx-arc-width: 20;");
                screen_buttons[y][x].getChildren().addAll(rec);
                grid.add(screen_buttons[y][x], x, y);
            }
        }

        //container for controls
        GridPane controls = new GridPane();

        root.setCenter(grid);
        root.setBottom(controls);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle(isSuccessful ? "Correct Path" : "Unsuccessful Attempt: " + attempt);
        primaryStage.show();

        if(!(index >= solution.size())){
            switch (solution.get(index)){
                case 1:
                    setCurrentY(getCurrentY()-1);
                    break;
                case 2:
                    setCurrentX(getCurrentX()-1);
                    break;
                case 3:
                    setCurrentY(getCurrentY()+1);
                    break;
                case 4:
                    setCurrentX(getCurrentX()+1);
                    break;
            }

            index++;
        }

        if(closeAtTheAnd && index == solution.size()){
            primaryStage.close();
        }

    }

    // This method finds if current coordinate is visited before or not
    // @param visitedList: List of visited points
    // @param x: x coordinate
    // @param y: y coordinate
    public boolean isVisited(ArrayList<ArrayList<Integer>> visitedList, int x, int y){
        boolean result = false;

        // Check if x and y coordinates are visited before
        for (ArrayList<Integer> temp : visitedList){
            if(temp.get(0) == x && temp.get(1) == y){
                result = true;
                break;
            }
        }

        return result;
    }

    public int getCurrentX() {
        return currentX;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public void handle(ActionEvent event) {
        run();
    }
}

// In another part of the code which I need to trigger the event above.
ArrayList<Integer> bestOfLastPopulation = geneticAlgorithm.findMostAte(finalPopulation, matrix, centerX, centerY);
VisualizationThread visualizationThread = new VisualizationThread(matrix, bestOfLastPopulation, centerX, centerY, true, 0, false);

Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.millis(150), visualizationThread));

fiveSecondsWonder.setCycleCount(bestOfLastPopulation.size() + 1);
fiveSecondsWonder.play();