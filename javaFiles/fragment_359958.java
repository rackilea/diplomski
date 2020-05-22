public class BackgroundEffectPane extends StackPane {

    public BackgroundEffectPane(Node content) {
        getChildren().addAll(createBackground(), freeze(...), content);
    }

    // code refactored from other answer...
}