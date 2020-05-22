try (BufferedReader r = Files.newBufferedReader(f.toPath(), Charsets.UTF_8)) {
    String line;
    while((line = r.readLine()) != null) {
        // do whatever you want with line
        System.out.println(line);
    }
} catch (IOException e) {
    e.printStackTrace();
}