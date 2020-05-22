for (Stock newStockItem: newStock) {
    Integer stockCode = newStockItem.getStockCode();
    Stock oldStockItem = netStockMap.get(stockCode);
    if (oldStockItem != null) {
        Stock netStockItem = new Stock(stockCode, oldStockItem.getStockQuantity() + newStockItem.getStockQuantity(),oldStockItem.getStockValue() + newStockItem.getStockValue());
        netStockMap.put(stockCode, netStockItem);

    } else {
        netStockMap.put(stockCode, newStockItem);
    }
}