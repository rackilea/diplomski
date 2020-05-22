public class WordType {

    private final StringProperty first = new SimpleStringProperty();
    private final StringProperty second = new SimpleStringProperty();

    public StringProperty firstProperty() {
        return first ;
    }

    public final String getFirst() {
        return firstProperty().get() ;
    }

    public final void setFirst(String first) {
        firstProperty().set(first);
    }


    public StringProperty secondProperty() {
        return second ;
    }

    public final String getSecond() {
        return secondProperty().get() ;
    }

    public final void setSecond(String second) {
        secondProperty().set(second);
    }
}