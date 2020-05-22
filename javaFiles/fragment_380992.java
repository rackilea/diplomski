MutationBatch m = 
    CassandraAstyanaxConnection.getInstance().getKeyspace().prepareMutationBatch();
ColumnListMutation<String> mutation = 
    m.withRow(CassandraAstyanaxConnection.getInstance().getEmp_cf(), userId);
for (Map.Entry<String, String> entry : attributes.entrySet()) {
    mutation = mutation.putColumn(entry.getKey(), entry.getValue(), null);
}