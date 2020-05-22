public void nextQuestion() {
    String[] currentQuestion = questions[currentQuestionIndex];

    hatZeichenbereichQuestion.setzeInhalt(currentQuestion[0]);
    hatEtikett2.setzeInhalt(currentQuestion[1]);
    hatEtikett3.setzeInhalt(currentQuestion[2]);
    hatEtikett4.setzeInhalt(currentQuestion[3]);

    currentQuestionIndex++; // increment to the next question index
}