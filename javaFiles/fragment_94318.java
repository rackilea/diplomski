Random random = new Random();

DateTime startTime = new DateTime(random.nextLong()).withMillisOfSecond(0);

Minutes minimumPeriod = Minutes.TWO;
int minimumPeriodInSeconds = minimumPeriod.toStandardSeconds().getSeconds();
int maximumPeriodInSeconds = Hours.ONE.toStandardSeconds().getSeconds();

Seconds randomPeriod = Seconds.seconds(random.nextInt(maximumPeriodInSeconds - minimumPeriodInSeconds));
DateTime endTime = startTime.plus(minimumPeriod).plus(randomPeriod);

DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

System.out.println(dateTimeFormatter.print(startTime));
System.out.println(dateTimeFormatter.print(endTime));