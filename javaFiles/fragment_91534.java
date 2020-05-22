public class SpecialFlashCard extends FlashCard {

    private ObservableList<Node> subclassChildren ;

    public SpecialFlashCard(int num1, int num2, int answer) {
        super(num1, num2, answer);
        subclassChildren = FXCollections.observableArrayList();
    }

    @Override
    public ObservableList<Node> getChildren() {
        return subclassChildren ;
    }
}