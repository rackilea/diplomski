try (final BufferedReader reader
         = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.US_ASCII))) {
  for (String line = reader.readLine(); line != null; line = reader.readLine()) {
    System.out.println(line);
  }
} catch (final IOException ex) {
  ex.printStackTrace();
}