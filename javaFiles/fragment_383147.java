Map<Integer, ClientPojo> questions = new HashMap<Integer, ClientPojo>();

while (rset.next()) 
{
  questionId = rset.getInt("QUESTION_ID");

  ClientPojo clientObj = questions.get(questionId);
  if( clientObj == null ) 
  {
    ClientPojo clientObj = new ClientPojo();

    questionOptions = rset.getInt("QUESTION_OPTIONS");
    passPercentage = rset.getInt("CATEGORY_PASS_PERCENTAGE");
    questionText = rset.getString("QUESTION_TEXT");
    questionType = rset.getString("QUESTION_TYPE");
    categoryName = rset.getString("CATEGORY_NAME");

    clientObj.setAssessmentAreaId(assessmentAreaId);
    clientObj.setCategoryName(categoryName);
    clientObj.setPassPercentage(passPercentage);
    clientObj.setQuestionOptions(questionOptions);
    clientObj.setQuestionText(questionText);
    clientObj.setQuestionType(questionType);
    clientObj.setQuestionId(questionId);

    questionsList.add(clientObj);
  }

  possibleAnswerText = rset.getString("POSSIBLE_ANSWER_TEXT");
  possibleAnswerCorrect = rset.getString("POSSIBLE_ANSWER_CORRECT");

  //I'll leave the Answert object for you
  clientObj.addPossibleAnswer( new Answer(possibleAnswerText, possibleAnswerCorrect ) );
}