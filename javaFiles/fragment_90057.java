String writeCompanyValues = "INSERT INTO BALANCESHEET (companies_id, Companies, ticker) "
                                        + "SELECT companies_id, Companies, ticker FROM companies WHERE ticker = ?";

stmt = con.prepareStatement(writeCompanyValues);
stmt.setString(1, ticker);
stmt.executeUpdate();