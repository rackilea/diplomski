public class ComponentTextEvent extends EventObject {

    private String text;

    public ComponentTextEvent(UIBuilder source, String text) {
        super(source);
        this.text = text;
    }

    public UIBuilder getBuilder() {
        return (UIBuilder) getSource();
    }

    public String getText() {
        return text;
    }

}