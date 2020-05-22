public void countWord(){

    String tokens[] = userInput.trim().replaceAll("\\s+", " ").split(" ");

    for(int i = 0; i < tokens.length; ++i) {
        Integer counter = bow.get(tokens[i]);
        if(counter == null) {
            counter = 0;
        }
        bow.put(tokens[i], ++counter);
    }
}