private List<String> getValuesFromDB(String columnName) {

    String sql = String.format("SELECT %s FROM pais WHERE paisnombre = ?", columnName);

    PreparedStatement paisyprovincia_BBDD = bd.prepareStatement(sql);    
    paisyprovincia_BBDD.setString(1,country.getSelectionModel().getSelectedItem().toString());

    // execute etc...
}