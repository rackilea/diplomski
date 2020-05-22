Platform.runLater(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
                    Scene scene = new Scene(root);
                    fxpanel.setScene(scene);
                } catch (Exception e) {
                    // TODO: handle exception
                    System.err.println("error : " + e.getMessage() + "cause : " + e.getCause() + "\n" + e.getStackTrace());
                }
            }
        });