// Moved all the setup for the ActiveMQ connection outside the loops
// Otherwise they would create a new connection/sessions for each iteration without being closed
factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
connection = factory.createConnection();
connection.start();
session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
destination = session.createQueue("TestQueue");
producer = session.createProducer(destination);

Class.forName("org.postgresql.Driver");
System.out.println("----------------------------");

// Made a try-with-resources block in order to auto close everything in case of failure, no need to remember to close them manually.
// Using prepared statements so that the query itself doesn't have to be parsed for each iteration
try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + vardbserver, vardbuser, vardbpassword);
     PreparedStatement stmt = c.prepareStatement("SELECT * FROM MESSAGES where xmin::varchar::bigint > ? and xmin::varchar::bigint < ? ");
     PreparedStatement max = c.prepareStatement("select max(xmin::varchar::bigint) as txid from messages")
) {
    c.setAutoCommit(false);

    // Keep track of the previous and next transaction id in order to provide windowed results
    Long previousTxId = 0L;
    Long nextTxId = 0L;

    while (true) { // Enter an infinite loop
        stmt.clearParameters(); // Remove any set parameters in the fetch query

        // Fetch the next transaction id by executing the prepared statement in max
        try (ResultSet rs = max.executeQuery()) {
            if (rs.next()) {
                nextTxId = rs.getLong(1);
            }
        }

        // Set the window in the messages query. 
        // Since the query has already been prepared, we only need to set the parameters
        stmt.setLong(1, previousTxId);
        stmt.setLong(2, nextTxId + 1);

        // Execute the statment fetching all messages that were created between previousTxId and nextTxId
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String message = rs.getString("MESSAGE");
                System.out.println("Message = " + message);
                TextMessage mssg = session.createTextMessage(message);
                System.out.println("Sent: " + mssg.getText());
                producer.send(mssg);
            }
            // Update previousTxId for the next iteration
            previousTxId = nextTxId; 
        }
        Thread.sleep(5000);
    }
}