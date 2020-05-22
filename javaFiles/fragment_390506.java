public class shopCellWorker extends ListCell<Shop> {
    Group rectGroup = new Group();
    public ShopCellWorker(ScrollBar hbar, List<CustomerVisit> visits) {
         visits.forEach(v -> {
             Rectangle r = new Rectangle();
             ... setup ...

             rectGroup.getChildren().add(r);
         }
         hbar.valueProperty().addListener(new UpdateListener());

    }

    private class UpdateListener implements ChangeListener {
        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
          // Have a calculated new possition here
          rectGroup.setTranslateX(calculatedNewXPos);
        }
    }
}