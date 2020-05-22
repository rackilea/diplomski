String sentencia = "UPDATE producto SET "
            + "Nombre_Producto= ?, "
            + "Marca_Producto = ?, "
            + "Presentacion_Producto=?, "
            + "Precio_Producto=?, "
            + "Punto_de_Reorden = ?, "
            + "Existencia = ? "
            + "where Id_Producto=?;";

    PreparedStatement pstm = con.prepareStatement(sentencia);

    pstm.setString(1, c.getNombre_Producto());
    pstm.setString(2, c.getMarca_Producto());
    pstm.setString(3, c.getPresentacion_Producto());
    pstm.setFloat(4, c.getPrecio_Producto());
    pstm.setInt(5, c.getPunto_de_Reorden());
    pstm.setInt(6, c.getExistencia());
    pstm.setInt(7, c.getId_Producto());