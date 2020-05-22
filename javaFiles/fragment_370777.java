for (int i = 0; i < numberOfQuestions; i++) 
{
    for (int j = 0; j < numberOfAnswers; j++) 
    {
        for (int k = 0; k < answerGroupList.get(j).getChildCount(); k++) 
        {
            ((RadioButton) answerGroupList.get(j).getChildAt(k)).setEnabled(false);
        }
    }
}