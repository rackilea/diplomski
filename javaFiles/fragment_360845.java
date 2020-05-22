public void start(Stage primaryStage) throws Exception{

    Parent root = FXMLLoader.load(getClass().getResource("real.fxml"));
    primaryStage.setTitle("LoL Ready To Win");
    primaryStage.setResizable(false);
    primaryStage.setScene(new Scene(root));

    try {

        input = new FileInputStream("config.properties");
        prop.load(input);

        if(prop.getProperty("name") != null){
            primaryStage.show();
        }else if(prop.getProperty("name") == null){

            try {
                Stage stage = new Stage();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("summ.fxml"));
                Parent root1 = loader.load();

                stage.setTitle("Insert Title Here");
                stage.setResizable(false);
                stage.setScene(new Scene(root1));

                stage.showAndWait();

                // if you need the input:
                SummController summController = loader.getController();
                String name = summController.getName();
                // do something with name...

                primaryStage.show();

            }catch(IOException e){
                e.printStackTrace();
            }
        }


    } catch (IOException ex) {
        ex.printStackTrace();
    } finally {
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // ...
}