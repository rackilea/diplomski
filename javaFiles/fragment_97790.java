@SuppressWarnings({ "unchecked", "rawtypes" })
public void generateChart() {
    for (int i = 0; i < engines.size(); i++) {
        XYChart.Series series = new XYChart.Series();
        series.setName(engines.get(i).toString());
        for (int j = 0; j < parameters.size(); j++) {
            final Data<String, Object> data = new XYChart.Data<>(parameters.get(j).toString(), param.get(i).get(j));
            data.setNode(new HoveredThresholdNodea(engines.get(i).toString(), param.get(i).get(j)));
            series.getData().add(data);
        }
        lineChart.getData().add(series);
        System.out.println(lineChart);
    }
}

class HoveredThresholdNodea extends StackPane {

    public HoveredThresholdNodea(String string, Object object) {
        setPrefSize(15, 15);

        final Label label = createDataThresholdLabel(string, object);

        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                getChildren().setAll(label);
                setCursor(Cursor.NONE);
                toFront();
            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                getChildren().clear();
            }
        });
    }

    private Label createDataThresholdLabel(String string, Object object) {
        final Label label = new Label(object + "");
        label.getStyleClass().addAll("default-color0", "chart-line-symbol", "chart-series-line");
        label.setStyle("-fx-font-size: 20; -fx-font-weight: bold;");

        System.out.println(string);
        if (string.equals("engine1")) {
            label.setTextFill(Color.RED);
            label.setStyle("-fx-border-color: RED;");
        } else if (string.equals("engine2")) {
            label.setTextFill(Color.ORANGE);
            label.setStyle("-fx-border-color: ORANGE;");
        } else {
            label.setTextFill(Color.GREEN);
            label.setStyle("-fx-border-color: GREEN;");
        }

        label.setMinSize(Label.USE_PREF_SIZE, Label.USE_PREF_SIZE);
        return label;
    }
}