public void handleButtonGo(ActionEvent Event) throws IOException {    //On go button press

        boolean validation = true;
        try {

            gameGrid.setVisible(true);
            placeShips();        

        }catch (Exception e){

            labelwarning.setText(e.getMessage());   //on error the program will stop trying to place ships and refresh any ships placed so far.
            validation = false;
            //gameGrid.getChildren().clear();
            //BoardSetup();
            PauseTransition wait = new PauseTransition(Duration.seconds(2));
            wait.setOnFinished((e) -> {
                /*YOUR METHOD*/      
                gameGrid.setVisible(false);
            });
            wait.play();        

        }
}