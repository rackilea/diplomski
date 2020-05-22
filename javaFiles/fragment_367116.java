public class Question
{
     private int question_no ;
     // The right answer for this question may be a , b or c 
     private String question_answer ;
     private int question_point ;

    public Question()
    {

    }

    /**
     * @return the question_id
     */
    public int getQuestion_id() {
        return question_no;
    }

    /**
     * @param question_id the question_id to set
     */
    public void setQuestion_id(int question_id) {
        this.question_no = question_id;
    }

    /**
     * @return the question_answer
     */
    public String getQuestion_answer() {
        return question_answer;
    }

    /**
     * @param question_answer the question_answer to set
     */
    public void setQuestion_answer(String question_answer) {
        this.question_answer = question_answer;
    }

    /**
     * @return the question_point
     */
    public int getQuestion_point() {
        return question_point;
    }

    /**
     * @param question_point the question_point to set
     */
    public void setQuestion_point(int question_point) {
        this.question_point = question_point;
    }
}