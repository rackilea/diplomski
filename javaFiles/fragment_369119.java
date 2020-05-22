public List<Pecas> pegarPecasById(List<Integer> ids) {
    if (ids.isEmpty()) {
        return new ArrayList<>(0);
    } else {
        String sql = ids.stream().map(Object::toString).collect(Collectors.joining(",", "SELECT * FROM pecas WHERE id_pecas IN (", ")"));

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {       
                Pecas pecas = new Pecas();
                pecas.setIdpecas(rs.getInt("id_pecas"));
                pecas.setNome(rs.getString("nome"));
                pecas.setQtd_Pecas(rs.getInt("qtdPecas"));
                pecaslist.add(pecas);
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(RequisicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return pecaslist;
    }
}