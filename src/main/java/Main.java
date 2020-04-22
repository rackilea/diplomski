import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Question> questions = new ArrayList<>();
        List<Answer> answers = new ArrayList<>();

        XmlMapper mapper = new XmlMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        ExecutorService executorService =
                new ThreadPoolExecutor(10, 20, 0L, TimeUnit.MILLISECONDS,
                                       new LinkedBlockingQueue<>());

        try {
            File input = new File("/Users/lracki/Desktop/diplomski podaci/Posts.xml");
            BufferedReader reader = new BufferedReader(new FileReader(input));

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.contains("PostTypeId=\"1\"")) {
                    Question value = mapper.readValue(line, Question.class);

                    if (value.Tags.contains("<java>")) {
                        questions.add(value);

                        if(questions.size() == 100){
                            final List<Question> list = new ArrayList<>(questions);
                            executorService.execute(() -> new QuestionRepository().saveBulk(list));

                            questions = new ArrayList<>();
                        }
                    }
                } else if (line.contains("PostTypeId=\"2\"")) {
                    Answer value = mapper.readValue(line, Answer.class);
                    answers.add(value);

                    if(answers.size() == 100){
                        final List<Answer> list = new ArrayList<>(answers);
                        executorService.execute(() -> new AnswerRepository().saveBulk(list));

                        answers = new ArrayList<>();
                    }
                }

            }

            if (questions.size() != 0) {
                final List<Question> list = new ArrayList<>(questions);
                executorService.execute(() -> new QuestionRepository().saveBulk(list));
            }

            if (answers.size() != 0) {
                final List<Answer> list = new ArrayList<>(answers);
                executorService.execute(() -> new AnswerRepository().saveBulk(list));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please scan in new file.");
        }

        System.out.println(questions.size());
        System.out.println(answers.size());

        executorService.shutdown();

    }
}
