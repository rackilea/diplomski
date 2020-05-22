String sqlPart = "(";
for (every symbol but last){
sqlPart += symbol;
sqlPart += ",";
}
sqlPart += lastSymbol;
sqlPart += ")";

String sql = "SELECT * FROM tbl_data WHERE id IN " + sqlPart;