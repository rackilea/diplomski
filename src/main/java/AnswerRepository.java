import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AnswerRepository {

    private static String INSERT_STATEMENT = "INSERT INTO ANSWER (ID, BODY) VALUES (?, ?)";
    private static String UPDATE_STATEMENT = "UPDATE ANSWER SET CODE = ? WHERE id = ?";

    public AnswerRepository() {
    }

    public void saveBulk(final List<Answer> answerList) {
        try (Connection connection = HConnectionPool.getConnection()) {
            connection.setAutoCommit(false);
            for (Answer answer : answerList) {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STATEMENT);
                preparedStatement.setInt(1, answer.Id);
                preparedStatement.setString(2, answer.Body);
                preparedStatement.execute();
            }
            connection.commit();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void updateBulk(final List<Answer> answerList) {
        try (Connection connection = HConnectionPool.getConnection()) {
            connection.setAutoCommit(false);
            for (Answer answer : answerList) {
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATEMENT);
                preparedStatement.setInt(2, answer.Id);
                preparedStatement.setString(1, answer.code);
                preparedStatement.executeUpdate();
            }
            connection.commit();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
