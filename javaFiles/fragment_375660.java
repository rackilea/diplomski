ArrayList<F> l = new ArrayList<F>();
String sql="SELECT * FROM f";
try {
    Statement s = connection.createStatement();
    ResultSet rSet = s.executeQuery(sql);
    while(rSet.next()) {
        int j=0;
        l.get(j).setF_id(rSet.getInt("f_id"));
        l.get(j).setF_name(rSet.getString("f_name"));
        j++;
    }