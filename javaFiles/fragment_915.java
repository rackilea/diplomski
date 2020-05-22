A a = new A();

    ..

    List<QuestionTemplate> templateListCopy = new LinkedList<>();
    for (QuestionTemplate template : a.qTemplateList) {
        List<QuestionList> questionListCopy = new LinkedList<>();
        for (QuestionList question : template.qList) {
            QuestionList questionCopy = new QuestionList();
            questionCopy.questionText = question.questionText;
            questionCopy.questionChoice = question.questionChoice;
            questionListCopy.add(questionCopy);
        }
        QuestionTemplate questionTemplateCopy = new QuestionTemplate();
        questionTemplateCopy.qList = questionListCopy;
        templateListCopy.add(questionTemplateCopy);
    }
    B b = new B();
    b.qTemplateList = templateListCopy;