private static void server() {
    ...
        while (true) {
            InputStream in = client.getInputStream();

            // read a newline or carriage-return-delimited string
            BufferedReader bin =
                    new BufferedReader( new InputStreamReader( in ) );
            String someString = bin.readLine();