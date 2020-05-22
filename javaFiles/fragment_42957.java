ProcessBuilder builder = new ProcessBuilder("/usr/bin/env", "python", "-i");
Process process = builder.start();

new Thread(() -> {
    String line;
    final BufferedReader reader = new BufferedReader(
            new InputStreamReader(process.getInputStream()));
    // Ignore line, or do something with it
    while (true)
        try {
            if ((line = reader.readLine()) == null)
                break;
            else
                System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
}).start();
new Thread(() -> {
    final PrintWriter writer = new PrintWriter(
            new OutputStreamWriter(process.getOutputStream()));
    writer.println("1");
    writer.println("2 * 2");
    writer.println("exit()");
    writer.flush();
}).start();