import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CodeFilter {

    public static void main(String[] args) throws IOException {

        List<Answer> answers = new ArrayList<>();

        ExecutorService executorService =
                new ThreadPoolExecutor(10, 20, 0L, TimeUnit.MILLISECONDS,
                                       new LinkedBlockingQueue<>());

        Statement stmt;

        long fragmentNumber = 0;

        try (Connection connection = HConnectionPool.getConnection()) {
            connection.setAutoCommit(false);

            stmt = connection.createStatement();

            String sql = "select * from answer where answer.id in (select question.acceptedAnswerId from question)";
            ResultSet rs = stmt.executeQuery(sql);


            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String body = rs.getString("body");

                fragmentNumber = geCodeFromBody(body, fragmentNumber);

                /*Answer answer = new Answer(id, body, code);

                answers.add(answer);

                if(answers.size() == 10000){
                    final List<Answer> list = new ArrayList<>(answers);
                    executorService.execute(() -> new AnswerRepository().updateBulk(list));

                    answers = new ArrayList<>();
                }*/
            }
            rs.close();

            /*if (answers.size() != 0) {
                final List<Answer> list = new ArrayList<>(answers);
                executorService.execute(() -> new AnswerRepository().updateBulk(list));
            }*/
        } catch (SQLException e) {
            System.err.println(e);
        }

        executorService.shutdown();

        System.out.println(fragmentNumber);

    }

    public static long geCodeFromBody(final String body, long fragmentNumber) {

        Document doc = Jsoup.parse(body);
        Elements link = doc.getElementsByTag("code");

        for (Element element : link) {
            String code = element.text();

            if(code.split("\r\n|\r|\n").length < 6){
                continue;
            }

            File input = new File("/Users/lracki/Desktop/diplomski/filtered2", "fragment_" + fragmentNumber++ + ".java");

            try {
                FileOutputStream out = new FileOutputStream(input);

                out.write(code.getBytes());
                out.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return fragmentNumber;
    }

    /*public static String geCodeFromBody(final String body) {
        StringBuilder code = new StringBuilder();

        Document doc = Jsoup.parse(body);
        Elements link = doc.getElementsByTag("code");

        for (Element element : link) {
            code.append(element.text()).append("\n");
        }

        return code.toString();
    }*/
}
