private void parseId(String str) {
    String[] tokens = str.split("\\|");

    for (int i = 0; i < tokens.length; i++) {
        if (tokens[i].equals("ID")) {
            String idValue = tokens[i + 1]; // this will throw an error if
                                            // there is nothing after ID on
                                            // the row
            System.out.println("Id is " + idValue);
            break;
        }
    }
}