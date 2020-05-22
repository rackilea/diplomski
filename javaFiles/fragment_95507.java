/**
     * Get a row
     */
    @Override
    public void getOneRecord(final String tableName, final String rowKey) throws IOException {
        final HTable table = new HTable(HBaseConn.getHBaseConfig(), getTable(tableName));
        final Get get = new Get(rowKey.getBytes());
        final Result rs = table.get(get);
        for (final KeyValue kv : rs.raw()) {
            LOG.info(kv.getRow() + " " + kv.getFamily() + ":" + kv.getQualifier() + " " + +kv.getTimestamp());
            LOG.info(new String(kv.getValue()));
        }
    }