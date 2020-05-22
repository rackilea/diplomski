// Build the question list:
List<String> questions = new ArrayList<>(15);
questions.add(question_1);
questions.add(question_2);
// etc...

// Shuffle it:
Collections.shuffle(questions);

// Ask the first ten:
List<String> questionsToAsk = questions.subList(0, 10);