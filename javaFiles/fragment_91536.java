public class FlashCard {

    private final Pane pane ;

    public FlashCard(int num1, int num2, int answer) {
        Label lblNum1 = new Label(Integer.toString(num1));
        Label lblNum2 = new Label(Integer.toString(num2));
        Label lblAnswer = new Label(Integer.toString(answer));

        VBox vbox = new VBox();
        vbox.getChildren().addAll(lblNum1, lblNum2, lblAnswer); 

        this.pane = new Pane();         
        this.pane.getChildren().add(vbox);
    }

    public Pane asPane() {
        return pane ;
    }
}