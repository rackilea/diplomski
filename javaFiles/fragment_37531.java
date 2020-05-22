try (BufferedReader buffer_input = new BufferedReader(
         new InputStreamReader(connection.getInputStream(), "cp1251"))) {
  String line;
  while ((line = buffer_input.readLine()) != null) {
    buffer_page.append(line);
  }
} catch (SocketTimeoutException ex) {
  /* handle time-out */
}