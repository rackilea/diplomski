private void currentScene() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                WebView view = new WebView();
                engine = view.getEngine();

                engine.createPopupHandlerProperty();
                engine.titleProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, final String newValue) {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                if (newValue != null) {
                                    //stores the title name in an arraylist
                                    title.add(newValue);
                                }
                            }

                        });
                    }
                });

                engine.locationProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> ov, String oldValue, final String newValue) {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                //stores the URL in another arraylist
                                if (title.size() == titleUrl.size() + 1) {
                                    titleUrl.add(newValue);
                                }
                                //sets the text of the location text field
                                locationTextField.setText(newValue);
                            }
                        });
                    }
                });

                jfxPanel.setScene(new Scene(view));
            }
        });
    }