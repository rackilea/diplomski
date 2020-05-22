public class QuestionBank {

    List<String> questions;
    int currQuestionIndex;

    public QuestionBank() {
        questions = new ArrayList<>(); // no size needed
        questions.add("Which three words describe you best?");
        questions.add("Which is your best feature?");
        // add more questions
        currQuestionIndex = 0; // it's 0 by default but this makes it explicit
        Collections.shuffle(questions); // shuffle all questions
    }

    public String getNextQuestion() {
        // get the next question, randomly from the list and without repeats
        if (currQuestionIndex >= questions.size()) {
            return null; // no more questions!
        }
        String nextQuestion = questions.get(currQuestionIndex);
        currQuestionIndex++; // move forward in the shuffled list
        return nextQuestion;
    }
}