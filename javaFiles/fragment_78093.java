String sql = "SELECT TaxBracket, FromSalary, ToSalary" +
              " FROM payroll_system.tax_info" +
             " WHERE FromSalary <= ?" +
               " AND (ToSalary >= ? OR ToSalary IS NULL)";
try (PreparedStatement stmt = con.prepareStatement(sql)) {
    stmt.setInt(1, salary);
    stmt.setInt(2, salary);
    try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
            taxBracket = rs.getInt("TaxBracket");
            fromSalary = rs.getInt("FromSalary");
            toSalary   = rs.getInt("ToSalary");
            if (rs.wasNull())
                toSalary = Integer.MAX_VALUE;
        }
    }
}