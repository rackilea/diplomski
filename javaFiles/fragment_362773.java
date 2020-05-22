public String getUserInput(String prompt) {
    String inputLine = null;
    System.out.print(prompt + "  ");
    try {
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        inputLine = is.readLine();
        if (inputLine.length() == 0)
            return null; // this cannot be parsed
    } catch (IOException e) {
        System.out.println("IOException: " + e);
    }
    return inputLine.toLowerCase(); //this might not be an integer
}