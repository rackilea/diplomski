// input: con, salary
int taxBracket = 0, fromSalary = 0, toSalary = 0;
String sql = "SELECT TaxBracket, FromSalary, ToSalary" +
              " FROM payroll_system.tax_info" +
             " WHERE ? BETWEEN FromSalary AND ToSalary";
try (PreparedStatement stmt = con.prepareStatement(sql)) {
    stmt.setInt(1, salary);
    try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
            taxBracket = rs.getInt("TaxBracket");
            fromSalary = rs.getInt("FromSalary");
            toSalary   = rs.getInt("ToSalary");
        }
    }
}