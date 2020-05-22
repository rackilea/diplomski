String query = "SELECT * FROM Table1 WHERE 1=1";

if (Field1Var != Value1) {
    query += " AND Field1 = ? ";
}

if (Field2Var != Value2) {
    query += " AND Field2 = ? ";
}

if (Field3Var != Value3) {
    query += " AND Field3 = ? ";
}

PreparedStatement s = conn.prepareStatement(query); 

int i = 0;

if (Field1Var != Value1) {
    s.setString(++i, Field1Var);
}

if (Field2Var != Value2) {
    s.setString(++i, Field2Var);
}

if (Field3Var != Value3) {
    s.setString(++i, Field3Var);
}