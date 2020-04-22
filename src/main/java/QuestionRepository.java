import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class QuestionRepository {

    private static String INSERT_STATEMENT = "INSERT INTO QUESTION (ID, ACCEPTEDANSWERID, TAGS) VALUES (?, ?, ?)";

    public QuestionRepository() {
    }

    public void saveBulk(List<Question> questionList) {
        try (Connection connection = HConnectionPool.getConnection()) {
            connection.setAutoCommit(false);
            for (Question question : questionList) {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STATEMENT);
                preparedStatement.setInt(1, question.Id);
                preparedStatement.setInt(2, question.AcceptedAnswerId);
                preparedStatement.setString(3, question.Tags);
                preparedStatement.execute();
            }
            connection.commit();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
