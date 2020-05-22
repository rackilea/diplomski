/**
     * Method getDetailRecords.
     * 
     * @param listOfRowKeys List<String>
     * @return Result[]
     * @throws IOException
     */
    private Result[] getDetailRecords(final List<String> listOfRowKeys) throws IOException {
        final HTableInterface table = HBaseConnection.getHTable(TBL_DETAIL);
        final List<Get> listOFGets = new ArrayList<Get>();
        Result[] results = null;
        try {
            for (final String rowkey : listOfRowKeys) {// prepare batch of get with row keys
   // System.err.println("get 'yourtablename', '" + saltIndexPrefix + rowkey + "'");
                final Get get = new Get(Bytes.toBytes(saltedRowKey(rowkey)));
                get.addColumn(COLUMN_FAMILY, Bytes.toBytes(yourcolumnname));
                listOFGets.add(get);
            }
            results = table.get(listOFGets);

        } finally {
            table.close();
        }
        return results;
    }