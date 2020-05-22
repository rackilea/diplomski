public class Controller {

    @FXML
    private FlowPane container ;
    @FXML
    private Label label1 ;
    @FXML
    private Label label2 ;
    // ...

    @FXML
    private Label label1000 ;

    private List<Label> labels ;

    public void initialize() throws Exception {
        labels = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            Field field = getClass().getDeclaredField("label"+i);
            boolean wasAccessible = field.isAccessible();
            field.setAccessible(true);
            Label label = (Label) field.get(this);
            field.setAccessible(wasAccessible);
            labels.add(label);
        }
    }
}