@Override
public void updateItem(String value, final boolean isEmpty) {
    super.updateItem(value, isEmpty);

    Platform.runLater(new Runnable() {

        @Override
        public void run() {
            if(!isEmpty) {
                    setStyle("-fx-font-weight:bold; -fx-font-size:10");
            }
        }

    });
}