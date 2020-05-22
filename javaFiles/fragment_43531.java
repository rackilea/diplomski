URL u = new URL("jar:file:/path/to/pgjdbc2.jar!/");
String classname = "org.postgresql.Driver";
URLClassLoader ucl = new URLClassLoader(new URL[] { u });
Driver d = (Driver)Class.forName(classname, true, ucl).newInstance();
DriverManager.registerDriver(new DriverShim(d));
DriverManager.getConnection("jdbc:postgresql://host/db", "user", "pw");