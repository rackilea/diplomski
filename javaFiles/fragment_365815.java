String createNullCheckedClause(String column, Object value) {
   String operator = (value == null ? "is" : "=");
   return String.format("(%s %s ?)", column, operator);
}

...

String query = "select * from table where " + createNullCheckedClause("col", x);