btnAdd.addEventHandler(ActionEvent.ACTION, (e)-> {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open Resource File");
    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("pictures file format",
            "*.TIF","*.JPG","*.PNG","*.GIF","*.JEPG");
    fileChooser.getExtensionFilters().addAll(extFilter);
    File file = fileChooser.showOpenDialog(null);

    if (file != null &&
            url.equals(emptyImageUrl)? true:alertMessageWarning("The viseme will change, and previous viseme will be delete.")) {
        setImage("file:"+file.toString());
        changeAfterSaved=false;
    }
});
btnAdd.addEventHandler(ActionEvent.ACTION, eventHandlerSetNotSave);