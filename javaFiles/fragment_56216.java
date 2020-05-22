HoveredThresholdNode(int priorValue, int value) {
      setPrefSize(15, 15);

      final Label label = createDataThresholdLabel(priorValue, value);
      getChildren().setAll(label);
      toFront();

    }