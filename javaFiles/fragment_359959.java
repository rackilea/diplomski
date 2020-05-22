public class BackgroundEffectPane {

    private final Node content ;

    private final Parent effectPane ;

    public BackgroundEffectPane(Node content) {
        this.content = content ;
        this.effectPane = new StackPane(createBackground(), freeze(...), content);
    }

    public Parent getEffectPane() {
        return effectPane ;
    }

    // other code...
}