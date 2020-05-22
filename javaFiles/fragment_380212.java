@FXML
public void goToMainMenu() throws IOException {
    stageLoader.loadStage(MAIN_MENU_FXML, stage);
    MainMenuController mainMenuController = stageLoader.getLoader().getController();
    mainMenuController.setStage(stage);
    mainMenuController.setStageLoader(stageLoader);
}