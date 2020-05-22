public class InventoryController {

    @FXML private void feedVenison(ActionEvent event) throws Exception {
        model.setHunger(someNewValue);
    }

    private Model model;

    public void setModel(Model model){
        this.model = model;
    }
}