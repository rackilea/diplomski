String curl = "curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{\"field1\": \"value1\", \"field2\": \"value2\"}' 'http://localhost:8080/service'";
ProcessBuilder builder = new ProcessBuilder("/bin/bash", "-c", curl);
builder.redirectErrorStream(true);
Process p = builder.start();
StringBuilder sb = new StringBuilder();
BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
String line;
int linenum = 0;
while (true) {
    linenum++;
    line = r.readLine();
    if (line == null) {
        break;
    }
    sb.append(line);
}
System.out.println(sb);