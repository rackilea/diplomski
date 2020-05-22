public void genericLayoutLoader(String fxmlFilename, Class rootFXMLElement, Class fxmlController) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(fxmlFilename));
            // Not sure for the Object below
            Object chooseUserAndInterval = loader.load();
            // rootAnchorPane is same for every layout
            rootAnchorPane.getChildren().clear();
            rootAnchorPane.getChildren().add(chooseUserAndInterval);

            Object controller = loader.getController();
            fxmlController.getMethod("setMainApp", new Class[] { MainApp.class }).invoke(controller, this);
        } catch (IOException e) {
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    public void showUserLayout() {
        genericLayoutLoader("view/userLayout.fxml", AnchorPane.class, Controller.class);  
    }