Collections.sort(dataList, new Comparator<Map<String, Object>>() {
    @Override
    public int compare(Map<String, Object> row1, Map<String, Object> row2) {
        Timestamp createDate1 = (Timestamp) row1.get("Creation Date");
        Timestamp createDate2 = (Timestamp) row2.get("Creation Date");
        return createDate1.compareTo(createDate2);
    }
});