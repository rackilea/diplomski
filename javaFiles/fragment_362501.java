List<String> clauses = new ArrayList<String>();
List<String> binds = new ArrayList<String>();

if (request.name != null) {
    binds.add(request.name);
    clauses.add("NAME = ?");
}

if (request.city != null) {
    binds.add(request.city);
    clauses.add("CITY = ?");
}

...

String whereClause = "";

for(String clause : clauses) {
    if (whereClause.length() > 0) {
        whereClause = whereClause + " AND ";
    }
    whereClause = whereClause + clause;
}

String sql = "SELECT * FROM table WHERE " + whereClause;

PreparedStatement ps = con.prepareStatment(sql);

int col = 1;
for(String bind : binds) {
    ps.setString(col++, bind);
}

ResultSet rs = ps.executeQuery();