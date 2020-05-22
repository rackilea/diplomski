public class Question {
    private String question; // This will hold the question
    private String[] choices;// This will hold the choices
    private String[] answers;// This will hold the correct answer/s, I made it an array since there might be
                                // a question that has multiple answers

    public Question(String question, String[] choices, String[] answers) {
        this.question = question;
        this.choices = choices;
        this.answers = answers;

    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question
     *            the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return the choices
     */
    public String[] getChoices() {
        return choices;
    }

    /**
     * @param choices
     *            the choices to set
     */
    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    /**
     * @return the answer
     */
    public String[] getAnswers() {
        return answers;
    }

    /**
     * @param answer
     *            the answer to set
     */
    public void setAnswer(String[] answer) {
        this.answers = answer;
    }

}