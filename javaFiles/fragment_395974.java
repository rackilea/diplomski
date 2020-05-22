tempColumn.setCellValueFactory(data -> {
    BasicDataSet set = data.getValue();
    if (columnHeader.equals("name")) {
        return new ReadOnlyStringWrapper(set.getName());
    } else if (columnHeader.equals("tagName")) {
        return new ReadOnlyStringWrapper(set.getTagName());
    } else {
        final String tempVal = set.getDataPoint(columnHeader);
        if(tempVal != null) {
            return new ReadOnlyStringWrapper(set.getDataPoint(columnHeader));
        } else {
            return new ReadOnlyStringWrapper("");
        }
    }
});