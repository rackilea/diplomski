import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class QuestionRepositoryTest {

    private QuestionRepository questionRepository = new QuestionRepository();

    @Test
    public void should_save_to_database() {
        final List<Question> request = new ArrayList<>();
        final Question question = new Question();
        question.Id = 1;
        question.Tags = "Tags";
        question.AcceptedAnswerId = 1;
        request.add(question);

        //OPERATE
        questionRepository.saveBulk(request);
    }

    @Test
    public void should_save_bulk() {
        final List<Question> request = new ArrayList<>();
        for (int i = 2; i < 1000000; i++) {
            final Question question = new Question();
            question.Id = i;
            question.Tags = "Tags";
            question.AcceptedAnswerId = i;
            request.add(question);
        }

        //OPERATE
        questionRepository.saveBulk(request);
    }

}