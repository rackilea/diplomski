public String getColumnText(Object cell, int columnIndex) {
    if (cell instanceof StockItem) {
        StockItem item = (StockItem) cell;

        switch(columnIndex) {
            case ID:
                return item.getID;
            case DESCRIPTION:
                return item.getDescription;
            case COUNT:
            Countable countableItem = item.adapt(Countable.class);
                return countableItem == null ? "N/A" : countableItem.getCount();
        }
    }
    return "N/A";
}