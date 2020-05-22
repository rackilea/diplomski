public class AdditionProblem(){

    private static Map<String, String> questions = createQuestions();

    private String problem;

    private String answer;

    private static Map<String, String> createQuestions() {
        Map<String, String> questions = new HashMap();
        questions.put("24 + 36 + 10", "70");
        //add as many more as you desire, but at least 10 total
        return questions;
    }

    public AdditionProblem(){
        //we first get the number of available questions
        int numberOfQuestions = questions.size();
        //we now generate a random again to choose which question to pick
        long random = Math.round((Math.random() * numberOfQuestions) + 1);
        //We pull they keySet from the map and use the random number as index, this is our question now
        problem = questions.keys().get(random);
        //we use the question to pull the answer
        answer = questions.get(problem);
        //as our last step, we remove the question from the list, so it is not pulled again
        questions.remove(problem);
    }

    public String getProblem(){
        return problem;
    }

    public String getAnswer(){
        return answer;
    }

}