for (j = 0; j < arrayCB.length; j++) {
     final int index = j;

    arrayCB[j].getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue ov, Number oldValue, Number newValue) {

            if ((Integer) newValue >= 0 && (arrayCB[index].getItems().get((Integer) newValue).equals("Easy")))
                arrayDifficulties[index] = "1";
            ...
        }
    });
}