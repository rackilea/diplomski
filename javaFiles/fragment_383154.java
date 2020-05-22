String writeValues = "INSERT INTO BalanceSheet (ticker, Year, " + columnName + ") "
                                    + "VALUES (?,?,?) "
        +"ON DUPLICATE KEY UPDATE " + columnName +"=?";

Statement statement = conn.prepareStatement(writeValues);
statement.setString(1,ticker);
statement.setString(2,stringResult.get(yearCount));
statement.setString(3, value);