Class.forName("net.sourceforge.jtds.jdbc.Driver");
    String username = "un";
    String password = "pass";

    conn = DriverManager.getConnection("jdbc:jtds:sqlserver://ip/db;user=" + username + ";password=" + password);

    Log.w("Connection","open");

    String sql = "INSERT INTO TABLE" +
            "(Cliente, NomePessoa, Email, NivelSatisfacao, Nota) " +
            "VALUES (?, ?, ?, ?, ?)";

    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, informacao.getNomeCliente())
        pstmt.setString(2, informacao.getNome())
        pstmt.setString(3, informacao.getEmail())
        pstmt.setString(4, informacao.getSatisfacao())
        pstmt.setString(5, informacao.getNota())

        int result = pstmt.executeUpdate();

    } catch (SQLException e) {
                e.printStackTrace();
    }