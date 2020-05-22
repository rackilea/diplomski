public class SomePresenter {

    @Inject
    private ViewModel viewModel ;

    @FXML
    public void someHandlerMethod() {
        SomeView someView = new SomeView();
        viewModel.setMainView(someView.getView());
    }
}