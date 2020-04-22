import java.util.Objects;


public class Question {

    public int Id;
    public int AcceptedAnswerId;
    public String Tags;

    public Question() {
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Question question = (Question) o;
        return Id == question.Id &&
                AcceptedAnswerId == question.AcceptedAnswerId &&
                Objects.equals(Tags, question.Tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, AcceptedAnswerId, Tags);
    }

    @Override
    public String toString() {
        return "Question{" +
                "Id=" + Id +
                ", AcceptedAnswerId=" + AcceptedAnswerId +
                ", Tags='" + Tags + '\'' +
                '}';
    }
}
