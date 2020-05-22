public void readSocket() {
    receivedTime = System.currentTimeMillis();
    requestFile = new File("recovery/" + receivedTime + ".txt");
    try(
        FileWriter fw = new FileWriter(requestFile);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(fw); 
    )
    {
        String line;

        // read request headers...
        do {
            line = in.readLine();

            if (line == null) return; // socket closed

            out.write(line);
            out.NewLine();
            out.flush();

            if (line.isEmpty()) break; // end of headers reached

            // process line as needed...
        }
        while (true);

        // check received headers for presence of a message
        // body, and read it if needed. Refer to RFC 2616
        // Section 4.4 for details...

        // process request as needed...

    } catch (IOException e) {
        e.printStackTrace();
    }
}