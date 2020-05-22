public class Model {
    private final ObjectProperty<Integer> v = new SimpleObjectProperty<>();

    public Model(Integer v) {
        this.v.setValue(v);
    }

    public final ObjectProperty<Integer> vProperty() {
        return this.v;
    }

    public final Integer getV() {
        return this.vProperty().get();
    }

    public final void setV(final Integer v) {
        this.vProperty().set(v);
    }
}

ObservableList<Model> list = FXCollections.observableArrayList();
list.addAll(new Model(20), new Model(-30), new Model(null), new Model(10));

TableView<Model> tv = new TableView<>();
TableColumn<Model, Integer> tc = new TableColumn<>();
tc.setCellValueFactory(new PropertyValueFactory<>("v"));
tv.getColumns().add(tc);
tv.setItems(list);

Comparator<Integer> ascComparator = (o1, o2) ->
                                (o1 != null ? o1 : Integer.MAX_VALUE) - 
                                (o2 != null ? o2 : Integer.MAX_VALUE);

Comparator<Integer> descComparator = (o1, o2) ->
                                (o1 != null ? o1 : Integer.MIN_VALUE) - 
                                (o2 != null ? o2 : Integer.MIN_VALUE);

@SuppressWarnings("unchecked")
Comparator<Integer> defaultComparator = TableColumn.DEFAULT_COMPARATOR;

tc.comparatorProperty().bind(
        Bindings.when(tc.sortTypeProperty().isEqualTo(SortType.ASCENDING))
                .then(ascComparator)
                .otherwise(
                        Bindings.when(tc.sortTypeProperty().isEqualTo(SortType.DESCENDING))
                                .then(descComparator)
                                .otherwise(defaultComparator)));