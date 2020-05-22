Object o = null;
try {
  Connection c = getConnection();
  o = c.getThing();
} catch (Exception e) {
  //handle exception; leave o as null
} finally {
  c.close();
}
return o;