public ControllerA(BorderPane root)
{
    String sceneFile = "A.fxml";
    URL url = null;
    try
    {
        url = getClass().getResource(sceneFile);
        FXMLLoader loader = new FXMLLoader(url);
        loader.setController(this);
        content = loader.load();
    }
    catch (Exception ex)
    {
            // TODO Auto-generated catch block
            e.printStackTrace();
    }
}