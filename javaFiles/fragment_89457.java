btn.setOnAction(new EventHandler<ActionEvent>()
{
    @Override
    public void handle(ActionEvent event)
    {
        FileChooser fileChooser = new FileChooser();

        // Set Initial Directory to Desktop
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home") + "\\Desktop"));

        // Set extension filter, only PDF files will be shown
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show open file dialog
        File file = fileChooser.showOpenDialog(primaryStage);

        //Open PDF file
        HostServices hostServices = getHostServices();
        hostServices.showDocument(file.getAbsolutePath());
    }
});