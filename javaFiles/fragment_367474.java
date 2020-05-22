/**
 * Put (or insert) a row
 */
@Override
public void addRecord(final String tableName, final String rowKey, final String family, final String qualifier,
                final byte[] yourcolumnasBytearray) throws Exception {
    try {
        final HTableInterface table = HBaseConnection.getHTable(getTable(tableName));
        final Put put = new Put(Bytes.toBytes(rowKey));
        put.add(Bytes.toBytes(family), Bytes.toBytes(qualifier), yourcolumnasBytearray);
        table.put(put);
        LOG.info("INSERT record " + rowKey + " to table " + tableName + " OK.");
    } catch (final IOException e) {
        printstackTrace(e);
    }