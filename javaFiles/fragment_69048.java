public class RootPresenter {
    @FXML 
    private BorderPane root ; // I think you have this?
    @FXML
    private AnchorPane center ; // possibly no longer need this?

    @Inject
    private ViewModel viewModel ;

    public void initialize() {
        root.centerProperty().bind(viewModel.mainViewProperty());
        MainView view = new MainView();
        viewModel.setMainView(view.getView());
    }
}