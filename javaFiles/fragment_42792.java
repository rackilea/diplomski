//Next, we have to wrap the byte array in an InputStream to accepted
InputStream is = new ByteArrayInputStream(t.getObject().getBytes());

//Then, instantiate an XMLType object by using native OracleConnection and InputStream of the byte array object
final XMLType xmldoc = new XMLType(conn, is);
...
ps.setObject(3, xmldoc);