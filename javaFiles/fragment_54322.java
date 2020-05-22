WorkTaskConfig taskConfig = reponse.body();

List<WorksNode> worksNode = taskConfig.getData().getWorksNode();
List<QuestionsNode> questionsNode = taskConfig.getData().getQuestionsNode();
List<AnswersNode> answersNode = taskConfig.getData().getAnswersNode();
List<AnswerSuggestionsNode> answerSuggestionsNode = taskConfig.getData().getAnswerSuggestionsNode();