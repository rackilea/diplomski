tableViewColumnString.setCellValueFactory(new Callback<CellDataFeatures<ClassExample>, ObservableValue<String>>() {
    @Override
    public ObservableValue<String> call(CellDataFeatures<ClassExample> cellData) {
       return new ReadOnlyStringWrapper(cellData.getValue().getClassExample2().getINFO());
    };
});