String computeForSlashline(String input) {

    String[] sentences = input.split("\.");
    for(int i = 0; i < sentences.length; i++) {
        // perform a search on each sentence, moving the #__# to the front
    }
    StringBuilder sb = new StringBuilder();
    for(String sentence : sentences) {
        sb.append(sentence).append(". ");
    }
    return sb.toString().trim();

}