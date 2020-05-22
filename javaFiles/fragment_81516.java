private static final DateTimeFormatter FORMATTER =
                DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss a z");
public static void main(String[] args) {
  ZonedDateTime ldt = ZonedDateTime.now();
  System.out.println(ldt.format(FORMATTER);
}