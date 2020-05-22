public class Controller {

    int n = 3;
    Button buttons[][] = new Button[n][n];

    EventManager em = new EventManager();

    @FXML
    private Parent root ;

    public void initialize() {

        for (int i=0; i < this.n; i++) {
            for (int j=0; j < this.n; j++) {
                String row = Integer.toString(i);
                String col = Integer.toString(j);
                Button btn = (Button) root.lookup("#"+row+col);
                btn.setStyle("-fx-base: white;");
                this.buttons[i][j] = btn;
            }
        }
    }

   // ...
}