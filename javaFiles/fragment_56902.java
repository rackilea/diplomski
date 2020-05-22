public void addMultipleRecordsAtaShot(final ArrayList<Put> puts, final String tableName) throws Exception {
        try {
            final HTable table = new HTable(HBaseConnection.getHBaseConfiguration(), getTable(tableName));
            table.put(puts);
            LOG.info("INSERT record[s] " + puts.size() + " to table " + tableName + " OK.");
        } catch (final Throwable e) {
            e.printStackTrace();
        } finally {
            LOG.info("Processed ---> " + puts.size());
            if (puts != null) {
                puts.clear();
            }
        }
    }