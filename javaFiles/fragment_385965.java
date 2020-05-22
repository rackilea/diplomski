try (ResultSet rs = connection.getMetaData().getImportedKeys(null, null, "CLIPPOINTS")) {

    while (rs.next()) {
         System.out.println(
             "  FK_NAME = " + rs.getString("FK_NAME")
           + ", FKTABLE_NAME = " + rs.getString("FKTABLE_NAME")
           + ", FKCOLUMN_NAME = " + rs.getString("FKCOLUMN_NAME"));
    }
}