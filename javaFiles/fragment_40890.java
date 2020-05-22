String par1 = "par1"; // intialized for testing
String par2 = null;
String par3 = "par3";

StringBuilder query = new StringBuilder("select * from table t");

if (par1 != null || par2 != null || par3 != null) {
    query.append(" where ");
    if (par1 != null) {
        query.append("t.var1 = ?");
    }
    if (par2 != null) {
        if (par1 != null) {
            query.append(" AND ");
        }
        query.append("t.var2 = ?");
    }
    if (par3 != null) {
        if (par1 != null || par2 != null) {
            query.append(" AND ");
        }
        query.append("t.var3 = ?");
    }
}

System.out.println(query);