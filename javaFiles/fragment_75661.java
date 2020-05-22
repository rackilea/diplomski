public class LDTTest {
    public static void main(String[] args) {
        final Calendar aMinuteAgo = Calendar.getInstance();
        aMinuteAgo.add(Calendar.MINUTE, -1);
        System.out.println(aMinuteAgo.getTime());
        LocalDateTime ofInstant = LocalDateTime.ofInstant(aMinuteAgo.toInstant(), ZoneId.systemDefault());
        System.out.println(ofInstant);

    }
}