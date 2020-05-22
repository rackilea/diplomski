QuestionnaireBeanWrapper wrapper = 
    ( QuestionnaireBeanWrapper ) session.getAttribute( examPart );
wrapper.getQuestionnaireBeanList().get( examNumber - 1 ).setQuestionAnswer( examAnswer );

QuestionnaireBeanWrapper wrapper2 = ( QuestionnaireBeanWrapper ) session.getAttribute( examPart );
System.out.println(( wrapper.getQuestionnaireBeanList().get( examNumber - 1 ).getQuestionAnswer() ==  wrapper2.getQuestionnaireBeanList().get( examNumber - 1 ).getQuestionAnswer())? "Same":"Different");