Mutator mutator = Pelops.createMutator(thrift_connection_pool);
ArrayList<Column> columnList = new ArrayList<Column>();
for (Map.Entry<String, String> entry : map.entrySet()) {
    columnList.add(mutator.newColumn(entry.getKey(), entry.getValue()));
}
mutator.writeColumns(column_family, String.valueOf(userId), columnList);