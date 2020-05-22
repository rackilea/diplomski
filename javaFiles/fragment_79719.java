ByteArrayOutputStream baos = new ByteArrayOutputStream();
ObjectOutputStream oos = new ObjectOutputStream(baos);
oos.writeObject(new Date());
oos.close();
// ...
preparedStatement.setBytes(i, baos.toByteArray());