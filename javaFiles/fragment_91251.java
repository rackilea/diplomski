private boolean a;
private boolean b;
private boolean c;
private Map<CheckBox, Consumer<Boolean>> eventMap = new HashMap<>();

private void comboAction(ActionEvent event) {
    CheckBox cb = (CheckBox) event.getSource();
    eventMap.get(cb).accept(cb.isSelected());
}

@Override
public void start(Stage primaryStage) {
    CheckBox cb1 = new CheckBox("a");
    CheckBox cb2 = new CheckBox("b");
    CheckBox cb3 = new CheckBox("c");

    // tell event handler what to do with the booleans
    eventMap.put(cb1, v -> a = v);
    eventMap.put(cb2, v -> b = v);
    eventMap.put(cb3, v -> c = v);

    // register event handlers
    EventHandler<ActionEvent> onAction = this::comboAction;

    for (CheckBox cb : eventMap.keySet()) {
        cb.setOnAction(onAction);
    }

    Button button = new Button("print");
    button.setOnAction(evt -> {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println("-------");
    });

    Scene scene = new Scene(new VBox(cb1, cb2, cb3, button));
    primaryStage.setScene(scene);
    primaryStage.show();
}