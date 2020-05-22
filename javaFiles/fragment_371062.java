Stage stage = ... ; // maybe it's the primary stage in start...
Scene scene = new Scene();
ViewModel viewModel = new ViewModel();

FXMLLoader aLoader = new FXMLLoader(getClass().getResource("/infoLibrary/view/A.fxml"));
Parent a = aLoader.load();
AController aController = aLoader.getController();
aController.setViewModel(viewModel);

FXMLLoader bLoader = new FXMLLoader(getClass().getResource("/infoLibrary/view/B.fxml"));
Parent b = bLoader.load();
BController bController = bLoader.getController();
bController.setViewModel(viewModel);

scene.rootProperty().bind(Bindings.createObjectBinding(() -> {
    if (viewModel.getCurrentView() == ViewModel.View.A) {
        return a ;
    } else if (viewModel.getCurrentView() == ViewModel.View.B) {
        return b ;
    } else {
        return null ;
    }
}, viewModel.currentViewProperty());

stage.setScene(scene);
stage.show();