@PostConstruct
void initUIPane(BorderPane pane){
    graph = createGraph();
    // configure application
    Injector injector = Guice.createInjector(createModule());
    domain = injector.getInstance(IDomain.class);
    viewer = domain.getAdapter(AdapterKey.get(IViewer.class, IDomain.CONTENT_VIEWER_ROLE));
    InfiniteCanvas canvas = (InfiniteCanvas)viewer.getCanvas();
    pane.setCenter(canvas);
    canvas.sceneProperty().addListener((observable, oldValue, newValue) -> {
      if (canvas.getScene() != null) {
        domain.activate();
        try {
            viewer.getContents().setAll(Collections.singletonList(graph));
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
}