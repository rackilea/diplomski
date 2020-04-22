import java.util.Objects;

public class Answer {

    public int Id;
    public String Body;
    public String code;

    public Answer() {
    }

    public Answer(final int id, final String body, final String code) {
        Id = id;
        Body = body;
        this.code = code;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Answer answer = (Answer) o;
        return Id == answer.Id &&
                Objects.equals(Body, answer.Body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Body);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "Id=" + Id +
                ", Body='" + Body + '\'' +
                '}';
    }
}
