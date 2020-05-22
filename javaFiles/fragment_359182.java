@Override
    public void start(Stage stage) {
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        PieChart pieChart = new PieChart(data);
        PieChart.Data one = new PieChart.Data("one", 50.0);
        PieChart.Data two = new PieChart.Data("two", 33.0);
        PieChart.Data three = new PieChart.Data("three", 17.0);
        data.addAll(one, two, three);
        one.getNode().addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            ScaleTransition st = new ScaleTransition(Duration.millis(1500),one.getNode());
            st.setByX(0.3);
            st.setByY(0.3);
            st.setCycleCount(1);
            st.setAutoReverse(false);
            st.play();

        });
        two.getNode().addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            ScaleTransition st = new ScaleTransition(Duration.millis(1500),two.getNode());
            st.setByX(0.3);
            st.setByY(0.3);
            st.setCycleCount(1);
            st.setAutoReverse(false);
            st.play();

        });
        three.getNode().addEventFilter(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            ScaleTransition st = new ScaleTransition(Duration.millis(1500),three.getNode());
            st.setByX(0.3);
            st.setByY(0.3);
            st.setCycleCount(1);
            st.setAutoReverse(false);
            st.play();

        });

        //create root group
        Group root = new Group();
        //set up window
        //add nodes to root
        root.getChildren().addAll(pieChart);
        Scene scene = new Scene(root, 500,500);
        stage.setTitle("Testing arc animation");
        stage.setScene(scene);
        stage.show();
    }