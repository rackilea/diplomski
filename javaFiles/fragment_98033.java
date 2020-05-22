public boolean areQuestionsLeft(){
    for (TrueFalse question: mQuestions)
    {
        if (question.isQuestionAnswered())
            return true;
    }
    return false;
}