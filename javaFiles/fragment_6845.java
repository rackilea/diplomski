public class VInputText extends HBox {

    private FontAwesomeIconView icon;
    private TextField textField;
    private Label label;

    public VInputText(double spacing) {

        this.setSpacing(spacing);
        this.setAlignment(Pos.CENTER_LEFT);
        this.setPrefSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);

        icon = new FontAwesomeIconView();
        icon.setGlyphName("TIMES");
        icon.setSize("1.3em");

        textField = new TextField();

        label = new Label("<- my validated field");

        this.getChildren().addAll(icon, textField, label);
    }
}