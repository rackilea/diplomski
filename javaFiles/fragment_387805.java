public void setView(String fxmlPath) {
         dynamicNode.setContent(getView(fxmlPath));
            currentlyInDynamicPane = fxmlPath;
   }


  public Node getView(String fxmlPath) {
        try {
            return new FXMLLoader(getClass().getResource(fxmlPath)).load();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }