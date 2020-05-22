Process process = new ProcessBuilder("C:\\Path\\To\\My\\Application.exe").start();

BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

StringBuilder output = new StringBuilder();
String line;
while ((line = reader.readLine()) != null) {
    output.append(line);
}

System.out.println(line);