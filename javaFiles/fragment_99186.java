public static void main(String[] args) {
    for (Question question : Question.values()) { // here is the "one for loop"
        String text = question.getText();         // here is the "one method call"
        println(question.toString());
        println(text);
    }
}