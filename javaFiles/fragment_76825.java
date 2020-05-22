try (InputStreamReader instream = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(instream)) {
    long length = 0;
    String line;
    while ((line = buffer.readLine()) != null) {
        length += line.length();
    }
    System.out.println("Read length: " + length);
} catch (Exception e) {
    e.printStackTrace();
}