// This is your input string
String value = "SomeValue";

// Your query goes here
PreparedStatement s = connection.prepareStatement(
    "UPDATE TheTable SET XmlField = ? WHERE Id = ?");

// Convert the input string to bytes according to the UTF-8 character encoding
byte[] varBinary = value.getBytes(StandardCharsets.UTF_8);

// Set the XmlField parameter in the prepared statement.
s.setBytes(1, varBinary)

// ID field
s.setInt(2, 42)