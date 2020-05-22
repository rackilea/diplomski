case ADMIN:

    // I'm assuming this code is on the AWT Event Dispatch thread

    JFrame window = new JFrame();
    JFXPanel jfxPanel = new JFXPanel();
    Platform.runLater(() -> {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdminView.fxml"));
            Parent root = loader.load();
            jfxPanel.setScene(new Scene(root, SCENEWIDTH, SCENEHEIGHT));
            // Give the controller access to the main app
            AdminController controller = loader.getController();
            controller.setMainApp();

            SwingUtilities.invokeLater(() -> {
                window.add(jfxPanel);
                window.pack();
                window.setVisible(true);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    });

break;