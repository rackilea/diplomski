Runtime r = Runtime.getRuntime();
Process p;
ProcessBuilder pb;
r = Runtime.getRuntime();
pb = new ProcessBuilder( 
    "D:\\Program Files\\PostgreSQL\\9.1\\bin\\pg_restore.exe",
    "--host=localhost",
    "--port=5432",
    "--username=postgres",
    "--dbname=mytestqq",
    "--role=postgres",
    "--no-password",
    "--verbose",
   "D:\\sathish\\rawDatabase.backup");
pb.redirectErrorStream(true);
p = pb.start();
InputStream is = p.getInputStream();
InputStreamReader isr = new InputStreamReader(is);
BufferedReader br = new BufferedReader(isr);
String ll;
while ((ll = br.readLine()) != null) {
 System.out.println(ll);
}