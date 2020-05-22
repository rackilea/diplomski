public class MainscenePresenter implements Initializable {

    @Inject
    private ViewState viewState ;

    @FXML
    AnchorPane breadcrumbAnchor;

    @FXML
    AnchorPane navigationAnchor;

    //------------------------------------------------------
    @FXML
    private AnchorPane mainAnchorPane; //ADD NEW ATPANE HERE

    private AtPresenter atPresenter;
    private AtView atView;

    //------------------------------------------------------
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //add BreadCrumBar WORKS
        BreadcrumbbarView breadcrumbbarView = new BreadcrumbbarView();
        breadcrumbbarView.getViewAsync(breadcrumbAnchor.getChildren()::add);

        //add DFD  WORKS
        DfdView dfdView = new DfdView();
        Parent view2 = dfdView.getView();
        this.mainAnchorPane.getChildren().add(view2);

        //add Navigation  WORKS
        NavigationView navigationView = new NavigationView();
        Parent view = navigationView.getView();
        navigationAnchor.getChildren().add(view);

        //add AT
        this.atView = new AtView();
        this.atPresenter = (AtPresenter) this.atView.getPresenter();

        this.viewState.atShowingProperty().addListener((obs, wasShowing, isNowShowing) -> {
            if (isNowShowing) {
                this.mainAnchorPane.getChildren().remove(this.atView.getView());
            } else {
                this.mainAnchorPane.getChildren().add(this.atView.getView());
            }
        });
    }      
}