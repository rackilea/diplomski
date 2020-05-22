public class GlobalOptionsController {

    // ...

    public void fileNameOptions(ActionEvent ev){
        try {
            if(fileNameOptions.getScene()==null){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/configHelp/globalOptionsFileName.fxml")); 
                Parent root = (Parent) loader.load();
                GlobalOptionsFileNameController fileAssistentController = loader.getController();

                fileAssistentController.filenameProperty().addListener((obs, oldFilename, newFilename) -> 
                    tf_fileName.setText(newFilename));

                Scene scene = new Scene(root);
                fileNameOptions.setTitle("Assistent zum festlegen der Speicherorte und Dateinamen");
                fileNameOptions.getIcons().add(new javafx.scene.image.Image("pictures/app-icon.png")); 
                fileNameOptions.setScene(scene);
                fileNameOptions.setResizable(false);
                fileNameOptions.setAlwaysOnTop(true);
                fileNameOptions.initModality(Modality.APPLICATION_MODAL);

                fileNameOptions.show();
            }else{
                fileNameOptions.show();
            }             
            } catch (IOException ex) {
                System.out.println("AddWindow: "+ex);
            }
    }

    // ...

}