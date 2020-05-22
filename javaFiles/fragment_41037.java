String insertTableSQL = "INSERT INTO informacion"
        + "(articulo , departamento , precio , cantidad ) VALUES"
        + "(?,?,?,?)";
PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
preparedStatement.setString(1, "jTextField1.getText()");
preparedStatement.setString(2, "jTextField2.getText()");
preparedStatement.setFloat(3, Float.parseFloat("jTextField3.getText()"));
preparedStatement.setInt(4, Integer.parseInt("jTextField4.getText()"));
// execute insert SQL stetement
preparedStatement .executeUpdate();