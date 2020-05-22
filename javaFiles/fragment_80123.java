Connection conn=getConnection();//some method to get a Connection
ScriptRunner runner=new ScriptRunner(conn, false, false);
InputStreamReader reader = new InputStreamReader(new FileInputStream("foo.sql"));
runner.runScript(reader);
reader.close();
conn.close();