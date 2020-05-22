public class MyControlSkin extends SkinBase<MyControl> {
    public MyControlSkin(MyControl control) {
        super(control);
        Label label = new Label("Some text here");

        getChildren().add(label);

    }
}