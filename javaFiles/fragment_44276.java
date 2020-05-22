import java.sql.Timestamp;

public class Main {

    public static void main(String[] args) {
        long inputLong = 1234567890l * 1000l;  // Constructor expects a milliseconds value

        Timestamp outputTimestamp = new Timestamp(inputLong);

        System.out.println (outputTimestamp);
    }

}