import android.text.format.DateFormat;

String dayOfTheWeek = (String) DateFormat.format("EEEE", date); // Thursday
String day          = (String) DateFormat.format("dd",   date); // 20
String monthString  = (String) DateFormat.format("MMM",  date); // Jun
String monthNumber  = (String) DateFormat.format("MM",   date); // 06
String year         = (String) DateFormat.format("yyyy", date); // 2013