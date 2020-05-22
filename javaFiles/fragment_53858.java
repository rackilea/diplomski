try (PrintStream ps = new PrintStream(new File("/Users/MyName/Desktop/something.txt"));
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    new URL("webPage").openStream()))) {
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            ps.println(inputLine);
            System.out.println(inputLine);
        }
    }