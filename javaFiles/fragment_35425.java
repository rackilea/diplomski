import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Person {
    private Date birthDate;
    static Date BOOM_START;
    static Date BOOM_END;

    public Person(Date birthDate) {
        this.birthDate = new Date(birthDate.getTime());
    }

    static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }

    public boolean isBabyBoomerWrong() {
        // Unnecessary allocation of expensive object
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomStart = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd = gmtCal.getTime();
        return birthDate.compareTo(boomStart) >= 0
                && birthDate.compareTo(boomEnd) < 0;
    }

    public boolean isBabyBoomer() {
        return birthDate.compareTo(BOOM_START) >= 0
                && birthDate.compareTo(BOOM_END) < 0;
    }

    public static void main(String[] args) {
        Person p = new Person(new Date());

        for (int i = 0; i < 10_000_000; i++) {
            p.isBabyBoomerWrong();
            p.isBabyBoomer();
        }

        long startTime = System.nanoTime();

        for (int i = 0; i < 10_000_000; i++) {
            p.isBabyBoomerWrong();
        }

        double estimatedSeconds = (System.nanoTime() - startTime) / 1000000000.0;
        System.out.println(String.format("Person::main: estimatedSeconds 1 = '%.2f'", estimatedSeconds));

        startTime = System.nanoTime();

        for (int i = 0; i < 10_000_000; i++) {
            p.isBabyBoomer();
        }

        estimatedSeconds = (System.nanoTime() - startTime) / 1000000000.0;
        System.out.println(String.format("Person::main: estimatedSeconds 2 = '%.2f'", estimatedSeconds));

    }
}