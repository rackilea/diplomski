try {
    ResultSet rs = Main.dbase.search("select * from myTable"); 
    while(rs.next()) {
        String result = rs.getString(1);
        if (result != null) {
            result = result.trim();
        }
        cmb.addItem(result);
    } 
    rs.close();
} catch (Exception ex) {
    System.out.println(ex);
}