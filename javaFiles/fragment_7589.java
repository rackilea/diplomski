connection.setAutocommit(false);
Statement stmt = con2.createStatement();

// this will automatically start a transaction
ResultSet rs = stmt.executeQuery("SELECT total_installment_remaining  FROM payment_loan WHERE loan_id = 1 FOR UPDATE");

// process the result if needed
...

stmt.executeUpdate("UPDATE payment_loan SET total_installment_remaining =total_installment_remaining-1 WHERE loan_id = 1");

// end the transaction and persist then changes
connection.commit();