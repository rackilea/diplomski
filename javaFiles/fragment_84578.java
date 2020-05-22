public class SomeController {

    public class SomeObject {}

    private List<SomeObject> sourceList;

    @FXML
    private ListView<SomeObject> aView;

    public void init(){

        aView.getItems().addAll(sourceList);

        // You can use method (which is strictly typed)
        aView.getItems().addListener(this::updateSource);

        // You can specify the type of the arguments
        aView.getItems().addListener((Change<? extends SomeObject> changes)->{
            ObservableList<? extends SomeObject> lst = changes.getList();
            sourceList.clear();
            sourceList.addAll(lst);
        });

        // You can specify the type of the functional interface
        aView.getItems().addListener((ListChangeListener<SomeObject>) changes->{
            ObservableList<? extends SomeObject> lst = changes.getList();
            sourceList.clear();
            sourceList.addAll(lst);
        });
    }

    private void updateSource(Change<? extends SomeObject> chg) {
        ObservableList<? extends SomeObject> data = chg.getList();
        sourceList.clear();
        sourceList.addAll(data);
    }

}