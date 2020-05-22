public void start(Stage primaryStage) {
        try {
            ListView<String> listView = new ListView<>();
            Button button = new Button("Get");
            List<String> list = new ArrayList<>();
            String[] toppings = { "Cheese", "Pepperoni", "Black Olives" };
            listView.getItems().addAll(toppings);
            listView.setCellFactory(CheckBoxListCell.forListView(new Callback<String, ObservableValue<Boolean>>() {
                @Override
                public ObservableValue<Boolean> call(String item) {
                    BooleanProperty observable = new SimpleBooleanProperty();
                    observable.addListener((obs, wasSelected, isNowSelected) -> {
                        if (isNowSelected) {
                            list.add(item);
                        } else {
                            list.remove(item);
                        }
                    });
                    return observable;
                }
            }));

            button.setOnAction(e -> {
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i));
                }
            });

            VBox root = new VBox();
            root.setAlignment(Pos.CENTER);
            root.getChildren().addAll(listView, button);
            Scene scene = new Scene(root, 300, 250);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }