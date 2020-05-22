DateTime dt = new DateTime();
String formatFirst = "EEEE dd'st'\nMMMM YYYY";
String formatSecond = "EEEE dd'nd'\nMMMM YYYY";
String formatThird = "EEEE dd'rd'\nMMMM YYYY";
String formatStd = "EEEE dd'th'\nMMMM YYYY";

String pattern;

switch (dt.getDayOfMonth()) {
  case 1:
  case 21:
  case 31:
    pattern = formatFirst;
    break;
  case 2:
  case 22:
    pattern = formatSecond;
    break;
  case 3:
  case 23:
    pattern = formatThird;
    break;
  default:
    pattern = formatStd;
}

String output = dt.toString(pattern, Locale.ENGLISH);
System.out.println(output);