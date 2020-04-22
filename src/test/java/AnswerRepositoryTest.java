import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AnswerRepositoryTest {

    private AnswerRepository answerRepository = new AnswerRepository();

    @Test
    public void should_save_to_database() {
        final List<Answer> request = new ArrayList<>();
        final Answer answer = new Answer();
        answer.Id = 1;
        answer.Body = "jsdkbajb";
        request.add(answer);

        //OPERATE
        answerRepository.saveBulk(request);
    }

    @Test
    public void should_update_in_database() {
        final List<Answer> request = new ArrayList<>();
        final Answer answer = new Answer();
        answer.Id = 1;
        answer.Body = "jsdkbajb";
        request.add(answer);

        //OPERATE
        answerRepository.saveBulk(request);
    }
}
