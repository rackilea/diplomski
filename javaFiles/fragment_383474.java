Process p = new ProcessBuilder()
        .command("powershell", "invoke-command", "-computerName", "MYCOMPUTER", "-filepath", ".\\someScript.psl")
        .start();
BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
p.waitFor();
List<String> results = new LinkedList();
String line;
while ((line == reader.readLine()) != null) results.add(line);