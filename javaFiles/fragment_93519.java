public interface Request {
    execute();
}

public class YearRangeRequest implements Request {
    int fromYear;
    int toYear;

    public execute();

... etc