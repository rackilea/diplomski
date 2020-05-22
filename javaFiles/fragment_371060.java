public class ViewModel {

    public enum View {A, B}

    private final ObjectProperty<View> currentView = new SimpleObjectProperty<>(View.A);

    public ObjectProperty<View> currentViewProperty() {
        return currentView ;
    }

    public final View getCurrentView() {
        return currentViewProperty().get();
    }

    public final View setCurrentView(View view) {
        currentViewProperty().set(view);
    }

}