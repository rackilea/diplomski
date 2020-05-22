String username = "someuser";
StringBuilder sql = new StringBuilder("update table1 set ");
for(int i=0; i < unumber; i++) {
    sql.append("column")
       .append(i).
       .append(" = ?");
    if (i != (unumber - 1)) {
        sql.append(", ");
    }
}
sql.append("where username = (?)");

PreparedStatement pr = con.prepareStatement(sql.toString());

for(int i = 0; i < unumber; i++) {
    pr.setString(i, array[i]);
}
pr.setString(unumber, someuser);
int s = pr.executeUpdate();