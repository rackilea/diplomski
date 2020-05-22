int len = String.valueOf(System.currentTimeMillis()).length();
    String startPrefix = getStrOfRepeatedChar(len, '0'),
            endPrefix = getStrOfRepeatedChar(len, '9');

    String startRow = startPrefix + String.valueOf(seperator) + wantedId,
            endRow = endPrefix + String.valueOf(seperator) + wantedId;
    RowRange rowRange = new RowRange(startRow, true, endRow, true);

    List<RowRange> rowRangeList = new ArrayList<>();
    rowRangeList.add(rowRange);

    Filter multiRowRangeFilter = new MultiRowRangeFilter(rowRangeList);