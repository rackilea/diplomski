public void countWord(){

    String tokens[] = userInput.trim().replaceAll("\\s+", " ").split(" ");

    for(int i = 0; i < tokens.length; ++i) {
        String token = tokens[i];
        Integer counter = bow.get(token);
        if(counter == null) {
            counter = 0;
        }
        bow.put(token, ++counter);
    }
}