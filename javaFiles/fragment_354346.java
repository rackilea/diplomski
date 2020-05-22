public class AmountLabel extends Label {
    public AmountLabel(String text) {
        super(text);

        textProperty().addListener(observable -> 
            System.out.println("Amount invalidated.")
        );
    }
}