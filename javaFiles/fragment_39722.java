//to initialize my checkComboBox
@FXML
CheckComboBox<String> addFeaturesCheckComboBox;

public void initialize() throws SQLException{

ObservableList<String> strings = FXCollections.observableArrayList();
     for (int i = 0; i <= 10; i++) {
         strings.add("Item " + i);
     }
addFeaturesCheckComboBox.getItems().addAll(strings);
//listen to the relevant events (e.g. when the selected indices or
     // selected items change).

     addFeaturesCheckComboBox.getCheckModel().getSelectedItems().addListener(new ListChangeListener<String>() {
         public void onChanged(ListChangeListener.Change<? extends String> c) {

             selectedFeatures = addFeaturesCheckComboBox.getCheckModel().getSelectedItems();
         }
     });
 }