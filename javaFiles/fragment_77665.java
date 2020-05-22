import java.util.*;

public class Johnann {

    private enum Person {JOHN, ANN}

    private static List<Long> getListForName(Person person, long n) {
        List<Long> ann = new ArrayList<>(Arrays.asList(1L));
        List<Long> john = new ArrayList<>(Arrays.asList(0L));

        for (int dayAnn = 1, dayJohn = 1; dayAnn < n || dayJohn < n; ) {
            if (john.size() > ann.get(dayAnn - 1)) {
                ann.add(dayAnn - john.get(Math.toIntExact(ann.get(dayAnn - 1))));
                dayAnn++;
            }
            if (ann.size() > john.get(dayJohn - 1)) {
                john.add(dayJohn - ann.get(Math.toIntExact(john.get(dayJohn - 1))));
                dayJohn++;
            }
        }
        return (person == Person.JOHN ? john : ann).subList(0, Math.toIntExact(n));
    }

    public static List<Long> john(long n) {
        return getListForName(Person.JOHN, n);
    }

    public static List<Long> ann(long n) {
        return getListForName(Person.ANN, n);
    }

    public static long sumJohn(long n) {
        return john(n).stream().mapToLong(Long::longValue).sum();
    }

    public static long sumAnn(long n) {
        return ann(n).stream().mapToLong(Long::longValue).sum();
    }
}