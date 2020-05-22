@FXML
private JFXDrawer mainDrawer;
private FlowHandler flowHandler;
private FlowHandler sideMenuFlowHandler;

context.register("ContentFlowHandler", flowHandler);
context.register("Settings", new Settings());
context.register("ContentFlow", innerFlow);