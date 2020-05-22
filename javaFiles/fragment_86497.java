@FXML
private void selectArea()
{
    Main.viewLoader.displayRootSelection((selectedId) -> {
        // Do something with the ID..
    });
}