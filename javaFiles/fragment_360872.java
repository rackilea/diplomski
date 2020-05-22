public ClienteCRUD(String nome, String cpf, String endereco, String cidade, String uf, String cep) throws SQLException {
            String[] str = {nome, cpf, endereco, cidade, uf, cep};
            String url = "jdbc:mysql://localhost/vendas";
            String sql = "insert into cliente (id_cliente, nomeCliente, enderecoCliente, cidade, cep, uf, cpf) values (?,?,?,?,?,?,?)";
            try (Connection con = DriverManager.getConnection(url, "root", "fabiio2");
            PreparedStatement stm = con.prepareStatement(sql)) {

            //for a sql complete parameter
            for (int i = 0; i < str.length; i++) {
                if (i == 0) {
                     stm.setInt(1, i + 4);
                     stm.setString(2, str[i]);
                }
                else {
                     stm.setString(i + 2, str[i]);
                }
            }
            // to move this 
            stm.addBatch();
            stm.executeBatch();            
          }
        }