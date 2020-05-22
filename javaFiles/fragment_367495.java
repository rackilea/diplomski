String sql = "insert into table (id, name, data) values " +
             "(sequence.nextval, ?, ?)";
PreparedStatement ps = super.getConnection().prepareStatement(sql);
InputStream stream = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
ps.setString(1, name);
ps.setBinaryStream(2, stream);
ps.executeUpdate();