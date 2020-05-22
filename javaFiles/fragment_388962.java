URL url = new URL("http://stackoverflow.com");

try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
    for (String line; (line = reader.readLine()) != null;) {
        System.out.println(line);
    }
}