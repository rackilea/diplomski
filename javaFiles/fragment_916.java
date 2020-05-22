class A {
    public List<QuestionTemplate> qTemplateList;

    public A copy() {
        A copy = new A();
        List<QuestionTemplate> questionTemplateListCopy = new ArrayList<>(qTemplateList.size());
        for (QuestionTemplate questionTemplate : qTemplateList) {
            questionTemplateListCopy.add(questionTemplate.copy());
        }
        copy.qTemplateList = questionTemplateListCopy;
        return copy;
    }
}

class QuestionTemplate {
    public List<QuestionList> qList;

    public QuestionTemplate copy() {
        QuestionTemplate copy = new QuestionTemplate();
        List<QuestionList> qListCopy = new ArrayList<>(qList.size());
        for (QuestionList questionList : qList) {
            qListCopy.add(questionList.copy());
        }
        copy.qList = qListCopy;
        return copy;
    }
}

class QuestionList {
    public String questionText;
    public String questionChoice;

    public QuestionList copy() {
        QuestionList copy = new QuestionList();
        copy.questionText = questionText;
        copy.questionChoice = questionChoice;
        return copy;
    }
}