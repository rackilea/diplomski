public static final String DATE_TIME_PATTERN = "dd-MM-yyyy hh:mm:ss.SSS a";

public static final DateFormat DATE_TIME_FORMAT = new SimpleDateFormat(DATE_TIME_PATTERN);

  public static final String SEPERATOR = ",";

    public static void main(String[] args) {
        try {
            Date date = DATE_TIME_FORMAT.parse("12-03-2019 10:28:50.013 AM");
            System.out.println("date : {} " + date);

            LocalDateTime startTimestamp = LocalDateTime.parse("12-03-2019 10:28:50.013 AM", DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)).plusNanos(1000000);
            System.out.println("startTimestamp : {} " + startTimestamp);
        } catch(Exception e) {
            e.printStackTrace();
        }

    }