InputStream input = imageUrl.openStream();

// ...

statement = connection.prepareStatement("INSERT INTO image (content) VALUES (?)");
statement.setBinaryStream(1, input);
statement.executeUpdate();