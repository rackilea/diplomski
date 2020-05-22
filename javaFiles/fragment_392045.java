String sql = "SELECT t.nome, h.Valor_Atual, h.Valor_Antigo, a.nome" +
              " FROM Historico h" +
              " JOIN Academista a ON a.Id_Academista = h.Id_Academista" +
              " JOIN Tecnologias t ON t.Id_Tecnologia = h.Id_Tecnologia" +
             " WHERE h.Valor_Atual LIKE ?" +
                " OR h.Valor_Antigo LIKE ?" +
                " OR a.nome LIKE ?";
try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    stmt.setString(1, "%" + ValToSearch + "%");
    stmt.setString(2, "%" + ValToSearch + "%");
    stmt.setString(3, "%" + ValToSearch + "%");
    try (ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            // code here
        }
    }
}