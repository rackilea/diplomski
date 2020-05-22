List<String> columns = Arrays.asList(new String[]{"col1","col2","col3"});
OperationResult<ColumnList<String>> result = CassandraConnection.getInstance().getKeyspace()
                .prepareQuery(CassandraConnection.getInstance().getEmp_cf())
                .getKey(userId).withColumnSlice(columns)
                .execute();
        ColumnList<String> columnList= result.getResult();
        for(String col : columns ){
            System.out.println(columnList.getColumnByName(col).getStringValue());
        }