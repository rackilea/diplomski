public class ViewModel {

    private final ObjectProperty<Node> mainView = new SimpleObjectProperty(this, "mainView", null);
    public ObjectProperty<Node> mainViewProperty() {
        return mainView ;
    }
    public final Node getMainView() {
        return mainView.get();
    }
    public final void setMainView(Node mainView) {
        this.mainView.set(mainView);
    }
}