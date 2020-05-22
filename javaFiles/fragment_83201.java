ResultSet resultSet = preparedSelectQuoteSql.executeQuery()) {
    while (resultSet.next()) {
        quoteBean = new QuoteBean(
            resultSet.getTimestamp("MySQLDateColumn")
        );
    }
}