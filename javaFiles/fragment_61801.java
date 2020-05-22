public class Question {
    String question;
    public Question(String placeQuestion) {
        question = q;
    }
}

public class Quiz {
    private ArrayList<Question> questions = new ArrayList<Question>();
    private int qindex=0;

    public void setQuestion(String q){
        Question setQ = new Question(q);
        questions.add(setQ);
        //each time here I create a "box" of Question class that has a String question in it 
    }
    public Question getNextQuestion(){
        Question q = questions.get(qindex);
        qindex++;
        return q;
    }
}