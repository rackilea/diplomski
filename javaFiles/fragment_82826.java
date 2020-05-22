public static String runCommand(String command) {
    String output = "";

    try {
        String line;
        Process process = Runtime.getRuntime().exec( command );

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()) );
        while ((line = reader.readLine()) != null) {
            output += line;
        }
        reader.close();


    } catch (Exception exception) {
        // ...
    }

    return output;
}