// The test string
String str = "Sun Oct 19 01:00:00 ADT 2014";

// Formatter for the input date
final DateTimeFormatter inputFormat = 
        DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy");

// The parsed date
final ZonedDateTime parsed = ZonedDateTime.parse(str, inputFormat);

// The output format(s). Specify the one you need
final DateTimeFormatter outputFormat1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
final DateTimeFormatter outputFormat2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

// Print
System.out.println(outputFormat1.format(parsed)); // -> 2014/10/19
System.out.println(outputFormat2.format(parsed)); // -> 2014-10-19