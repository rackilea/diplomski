ListDataProvider<Type> dataProvider = (ListDataProvider<Type>) grid.getDataProvider();
int totalSize = dataProvider.getItems().size();
DataCommunicator<Type> dataCommunicator = grid.getDataCommunicator();
Stream<Type> stream = dataProvider.fetch(new Query<>(
        0,
        totalSize,
        dataCommunicator.getBackEndSorting(),
        dataCommunicator.getInMemorySorting(),
        dataProvider.getFilter()));
List<Type> list = stream.collect(Collectors.toList());