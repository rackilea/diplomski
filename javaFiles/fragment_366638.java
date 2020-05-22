String sql = "INSERT INTO Dependente" +   
             + " (IdAssoc, NomeDep, SobrenomeDep, RgDep, CpfDep, DtNascDep, emailDep, tipoDep, DtCriacaoDep)" +
             + " VALUES (?,?,?,?,?,?,?,?,?)";

try (PrepareStatement pstmt = con.prepareStatement(sql)) {
    pstmt.setLong(1, dependente.getAssociado());
    pstmt.setString(2, dependente.getNome());
    pstmt.setString(3, dependente.getSobrenome());
    ...

    pstmt.executeUpdate();
} // automatically closes statement (see try-with-resource above)