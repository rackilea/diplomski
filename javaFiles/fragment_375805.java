import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Question {
    public String QuestionNumber;
    public String title;
    public String description;

    public Question(String questionNumber, String title, String description) {
        super();
        QuestionNumber = questionNumber;
        this.title = title;
        this.description = description;
    }

    public String getQuestionNumber() {
        return QuestionNumber;
    }

    public void setQuestionNumber(String questionNumber) {
        QuestionNumber = questionNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Question [QuestionNumber=" + QuestionNumber + ", title=" + title + ", description=" + description + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        List<Question> questionlist = new ArrayList<>();
        questionlist.add(new Question("12.2", "titleA", "titleA_Desc"));
        questionlist.add(new Question("12.1", "titleB", "titleB_Desc"));
        questionlist.add(new Question("12.3", "titleC", "titleC_Desc"));
        questionlist.add(new Question("12.10", "titleD", "titleD_Desc"));
        questionlist.add(new Question("12.4", "titleE", "titleE_Desc"));

        Collections.sort(questionlist, new Comparator<Question>() {

            @Override
            public int compare(Question q1, Question q2) {
                String q1NumParts[] = q1.getQuestionNumber().split("\\.");
                String q2NumParts[] = q2.getQuestionNumber().split("\\.");
                if (Integer.parseInt(q1NumParts[0]) > Integer.parseInt(q2NumParts[0])) {
                    return 1;
                } else if (Integer.parseInt(q1NumParts[0]) < Integer.parseInt(q2NumParts[0])) {
                    return -1;
                } else {
                    if (Integer.parseInt(q1NumParts[1]) > Integer.parseInt(q2NumParts[1])) {
                        return 1;
                    } else if (Integer.parseInt(q1NumParts[1]) < Integer.parseInt(q2NumParts[1])) {
                        return -1;
                    }
                }
                return 0;
            }
        });

        for (Question q : questionlist) {
            System.out.println(q);
        }
    }
}