String driver = "org.apache.derby.jdbc.EmbeddedDriver";
...
try {
    Class.forName(driver); 
} catch(java.lang.ClassNotFoundException e) {
  ...
}