@Override
    public void initialize(URL url, ResourceBundle rb) {


        try {
            // TODO
            File selectedFile = new File("splash.png");
            if(selectedFile.exists())
            {
                System.out.println(selectedFile.getAbsolutePath());
            }
            //Image image = new Image(selectedFile.toURI().toURL().toString());
            //Image image = new Image(getClass().getResourceAsStream(selectedFile.getCanonicalPath()));
            Image image = new Image(selectedFile.toURI().toURL().toString());
            ImageView ivMain = new ImageView(image);
            ivMain.fitHeightProperty().bind(apMain.heightProperty());
            ivMain.fitWidthProperty().bind(apMain.widthProperty());
            Button btn2 = new Button("", ivMain);
            apMain.getChildren().add(btn2);
            btn2.setMaxWidth(Double.MAX_VALUE);
            btn2.setMaxHeight(Double.MAX_VALUE);


            apMain.widthProperty().addListener(new ChangeListener<Number>(){
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    btn2.setPrefWidth(newValue.intValue());
                }

            });

            apMain.heightProperty().addListener(new ChangeListener<Number>(){
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    btn2.setPrefHeight(newValue.intValue());
                }

            });
        } catch (MalformedURLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }



    }