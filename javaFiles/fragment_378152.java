ResultSet rs = null; 
try {
    final List<String> allItems = new ArrayList>String>();
    rs = Main.dbase.search("select * from myTable"); 
    while(rs.next()) {
        String result = rs.getString(1);
        if (result != null) {
            result = result.trim();
        }
        allItems.add(result);
    }
    SwingUtilities.invokeLater(new Runnable() {
        @Overrive public run() {
            for (String item: allItems) {
                cmb.addItem(item);
            }
        }
    });
} catch (Exception ex) {
    ex.printStacktrace();
} finally {
    if (rs != null) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}