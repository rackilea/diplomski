tempColumn.setCellValueFactory(data -> {
    BasicDataSet set = data.getValue();
    if (columnHeader.equals("name")) {
        return set.nameProperty();
    } else if (columnHeader.equals("tagName")) {
        return set.tagNameProperty();
    } else {
        return set.getObservableDataPoint(columnHeader);
    }
});