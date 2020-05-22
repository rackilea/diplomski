public Querellante buscarQuerellante(String cedula) throws java.sql.SQLException,Exception{
    String sql = "SELECT DireccionQ,NombreQ,ApellidosQ,TelefonoQ,CedulaQ "+
        "FROM tquerellante "+
        "WHERE CedulaQ=?";
    try (Connnector conn = ...; // TODO
        PreparedStatement ps = conn.prepareStatement(sql);
        )
    {
        ps.setObject(1, cedula);
        try (ResultSet rs = ps.execute())
        {
            if (rs.next()){
                return new Querellante(
                    rs.getString("DireccionQ"),
                    rs.getString("NombreQ"),
                    rs.getString("ApellidosQ"),
                    rs.getString("TelefonoQ"),
                    rs.getString("CedulaQ"));
            } else {
                throw new Exception ("Persona no encontrada intentelo de nuevo.");
            }
        }
    }
}