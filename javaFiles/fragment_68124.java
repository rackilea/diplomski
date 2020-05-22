durat.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<SimpleTask, Duration>, ObservableValue<Duration>>() {
    @Override
    public ObservableValue<Duration> call(TreeTableColumn.CellDataFeatures<SimpleTask, Duration> simpleTaskDurationCellDataFeatures) {
        return simpleTaskDurationCellDataFeatures.getValue().getValue().durationProperty();
    }
});