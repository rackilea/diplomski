private CheckBox checkBoxA;
private CheckBox checkBoxB;
private ObservableMap<ModuleType, Boolean> map;

@Override
public void start(Stage primaryStage) {
    checkBoxA = new CheckBox("type A");
    checkBoxB = new CheckBox("type B");

    map = FXCollections.observableMap(new EnumMap<>(ModuleType.class));

    initMapListeners();

    Thread t = new Thread(() -> {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            boolean b1 = random.nextBoolean();
            boolean b2 = random.nextBoolean();
            Platform.runLater(() -> {
                map.put(ModuleType.TYPEA, b1);
                map.put(ModuleType.TYPEB, b2);
            });
        }
    });
    t.setDaemon(true);
    t.start();

    Scene scene = new Scene(new VBox(10, checkBoxA, checkBoxB));

    primaryStage.setScene(scene);
    primaryStage.show();
}