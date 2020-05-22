// Build the question list:
String[] questions = new String[15];
questions[0] = question_1;
questions[1] = question_2;
// etc...

// Shuffle the first 10 elements.
// Although the elements can be taken from indexes above 10,
// there no need to continue shuffling these indexes.
Random r = new Random();
for (int i = 0; i < 10; ++i) {
    int swapIndex = r.nextInt(15 - i) + i;
    String temp = questions[i];
    questions[i] = questions[swapIndex];
    questions[swapIndex] = temp;

// Ask the first ten:
String[] questionsToAsk = new String[10];
for (int i = 0; i < 10; ++i) {
    questionsToAsk[i] = questions[i];
}