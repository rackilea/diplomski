public void initManager(final LoginManager loginManager) {
    btnEntrar.setOnAction(new EventHandler<ActionEvent>() {
    boolean mainThread = Platform.isFxApplicationThread();
            System.out.println("This is the main Thread: " + mainThread);

            Platform.runLater(new Runnable() {

                @Override
                public void run() {
                    progressInd.setVisible(true);
                }
            });

            new Thread() {
                public void run() {

                    boolean mainThread = Platform.isFxApplicationThread();
                    System.out.println("This is the main Thread: " + mainThread);

                    String email = loginTxtField.getText().trim();
                    String token = tokenTxtField.getText().trim();

                    if (email.equals("")) {
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Dialog.showError("Erro", "Digite o e-mail");
                            }
                        });
                        return;
                    }

                    try {

                        Future future = loginProcess(email, token);

            //            showLoginLoading(future);

                        future.get();

                        if (!loginGatewayFailed && !loginTargetAppFailed) {

                            Login loginTargetApp = new Login(email, null, null);
                            loginManager.autheticated(loginTargetApp, loginGateway, gateway, file);

                        } else {

                            if (loginTargetAppFailed) {

                                Platform.runLater(new Runnable() {
                                    public void run() {
                                        Dialog.showError("Erro", loginTargetAppFailedCause);
                                    }
                                });

                            } else {

                                if (loginGatewayFailed) {

                                    Platform.runLater(new Runnable() {
                                        public void run() {
                                            Dialog.showError("Erro", loginGatewayFailedCause);
                                        }
                                    });
                                }
                            }
                        }

                    } catch (final Exception ex) {

                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, ex.getMessage());

                        Platform.runLater(new Runnable() {
                            public void run() {
                                Dialog.showError("Erro", ex.getMessage());
                            }
                        });
                    }


                }
            }.start();
           });
        }