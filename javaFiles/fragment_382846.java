private static void server() {
    ...
        InputStream in = client.getInputStream();
        BufferedReader bin =
                new BufferedReader( new InputStreamReader( in ) );

        while (true) {
            // read a newline or carriage-return-delimited string
            String someString = bin.readLine();