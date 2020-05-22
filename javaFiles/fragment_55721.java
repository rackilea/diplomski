URLConnection connection = new URL("http://stream.meetup.com/2/open_events").
                                 openConnection();
    connection.setRequestProperty("User-Agent", "Lynx");
    connection.connect();
    BufferedReader in = new BufferedReader(new InputStreamReader(
    connection.getInputStream()));
    String inputLine;
    while ((inputLine = in.readLine()) != null){
        System.out.println(inputLine);
    }
    in.close();