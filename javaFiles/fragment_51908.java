public static void main (String [] args) {
    Path file = INSERT WHATEVER YOU WANT HERE;
    Queue1 lane = new Queue1(100);
    lane.create(0, 0);
    try {
       InputStream in = Files.newInputStream(file);
        BufferedReader reader =
          new BufferedReader(new InputStreamReader(in))) {
        String line = null;
        while ((line = reader.readLine()) != null) {
            // Leave the println to make sure you read coorectly
            System.out.println(line);
            lane.ENQUEUE(line);
    }
    } catch (IOException x) {
        System.err.println(x);
    }
}