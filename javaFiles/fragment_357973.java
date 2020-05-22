List<Map<String, Object>> data = getResultSet(syndicatorName);
for (int rowIdx = 0; rowIdx < data.size(); i++) {
    Map<String, Object> row = data.get(rowIdx);
    for (Map.Entry<String, Object> cell : row.entrySet()) {
        System.out.printf("Row %d cell %s: %s\n", rowIdx, cell.getKey(), cell.getValue());
    }
}