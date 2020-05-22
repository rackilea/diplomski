Connection conn;
        try {
            conn = DriverManager.getConnection("connection parameter's");

            Statement stmt = conn.createStatement();  // establish connection and make a table for the data.


            // COPY statement
            conn.setAutoCommit(false);


            // Drop table and recreate.
            stmt.execute("DROP TABLE IF EXISTS customers CASCADE");
            stmt.execute("CREATE TABLE customers (CustID int, Last_Name  char(50), First_Name char(50),Email char(50), "
                            + "Phone_Number char(12))");

            // Some dummy data to insert. 
            String[] firstNames = new String[] { "Anna", "Bill", "Cindy","Don", "Eric" };
            String[] lastNames = new String[] { "Allen", "Brown", "Chu", "Dodd", "Estavez" };
            String[] emails = new String[] { "aang@example.com", "b.brown@example.com", "cindy@example.com","d.d@example.com", "e.estavez@example.com" };
            String[] phoneNumbers = new String[] { "123-456-7890", "555-444-3333", "555-867-5309", "555-555-1212", "781-555-0000" };
            // Create the prepared statement
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO customers (CustID, Last_Name, " + 
                            "First_Name, Email, Phone_Number)  VALUES(?,?,?,?,?)");

            // Add rows to a batch in a loop. Each iteration adds a
            for (int i = 0; i < firstNames.length; i++) {

                pstmt.setInt(1, i + 1);
                pstmt.setString(2, lastNames[i]);
                pstmt.setString(3, firstNames[i]);
                pstmt.setString(4, emails[i]);
                pstmt.setString(5, phoneNumbers[i]);
                pstmt.addBatch();  // Add row to the batch.
            }

            try {
                // Batch is ready, execute it to insert the data
                pstmt.executeBatch();
            } catch (SQLException e) {
                System.out.println("Error message: " + e.getMessage());
                return; // Exit if there was an error
            }

            // Commit the transaction to close the COPY command
            conn.commit();
            conn.close();