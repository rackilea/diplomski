QAData(String questionText, String[] answerText, Boolean[] correctAnswer, Boolean[] selectedAnswer){
    assertLengthIs4(answerText, correctAnswer, selectedAnswer);       
    this.questionText = questionText;
    this.answerText = answerText;
    this.correctAnswer = correctAnswer;
    this.selectedAnswer = selectedAnswer;
}

public void assertLengthIs4(Object[]... arrays){
       for (Object[] array : arrays){
           if (array == null || array.length != 4){
               throw new IllegalArgumentException("size should be 4 for all arrays");
           } 
       } 
}