while (rs.next()) { //Se existe registro no banco de dados com os dados informados na tela de login...

        String nivelAcesso = rs.getString("nivelAcesso"); //Comparando valor de atríbuto "nivelAcesso" do banco de dados

        result.add(nivelAcesso);
    }