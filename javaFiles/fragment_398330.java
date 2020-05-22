public String Question (String quesion)
{
    RandomMathQuestionGenerator questionGenerator = new RandomMathQuestionGenerator();
    List<Question> randomQuestions = questionGenerator.getGeneratedRandomQuestions();
    for (Question question : randomQuestions) 
    {
        System.out.println(question);//prints questions
    }
    Random random = new java.util.Random();
    return randomQuestions.get(random.nextInt(randomQuestions.size())).toString();
}