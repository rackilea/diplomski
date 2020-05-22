public String cutText(String messageContent){
    boolean matchFound = false;
    StringBuilder output = new StringBuilder();
    try {
        reader = new BufferedReader(
                new StringReader(messageContent));
    } catch (Exception failed) { failed.printStacktrace(); }


    try {
        while ((string = reader.readLine()) != null) {

            if ((string.length() > 0) && (string.contains("Geachte"))) {
               matchFound = true;
            }
            if(matchFound){
                 output.append(string).append("\\n");
            }
        }
     } catch (IOException e) { e.printStacktrace();}
     return output.toString();
}