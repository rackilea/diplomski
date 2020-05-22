private void covertColumnValueList(String query_column_values) {
    String temp_val = null;

    for (String col_val : query_column_values.split(",")) {

        if (col_val.contains("\'")) {
            temp_val = col_val.replaceAll("\'", "");
            column_values_list.add(temp_val.trim());
        } else
            column_values_list.add(col_val.trim());
    }
}