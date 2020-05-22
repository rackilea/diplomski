try {

    Parent root=FXMLLoader.load(getClass().getResource("/eLearning/UserInterface/TutorControlPanel.fxml"));
    Scene scene = new Scene(root);

      String css = this.getClass().getResource("Style.css").toExternalForm();
                        scene.getStylesheets().add(css);
                        Stage stage = new Stage();

                        stage.setTitle("Tutor Control Panel");

                        stage.setScene(scene);
                        stage.show();

                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    System.out.println("user not found");

                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }