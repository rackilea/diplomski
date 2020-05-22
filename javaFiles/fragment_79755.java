BufferedInputStream bf = new BufferedInputStream(System.in)

BufferedReader r = new BufferedReader(
        new InputStreamReader(bf, StandardCharsets.UTF_8));

String line = r.readLine();
System.out.println(line);