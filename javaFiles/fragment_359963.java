List<String> tablecols = Arrays.asList("first_col", "second_col");
List<Column> columns = new ArrayList<Column>();

for (String tablecol : tablecols) {
    columns.add(new Column(tablecol));
}

initialDataFrame.select(columns.toArray(new Column[columns.size()]));