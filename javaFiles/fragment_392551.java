public static void main(String[] args) throws Exception {
    String _answer = "HANGMAN";
    _answer = _answer.replaceAll("[a-zA-Z]", "_"); // replace each letter with an "_"
    System.out.println(_answer);

}