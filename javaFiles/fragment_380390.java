String input = "12B17T"; // according to the other SO-post
String month = input.substring(2, 3);

if (month.equals("A")) {
  month = "10";
} else if (month.equals("B")) {
  month = "11";
} else if (month.equals("C")) {
  month = "12";
} else {
  month = "0" + month;
}

String date = input.substring(0, 2) + month + input.substring(3, 5);
SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
Date d = sdf.parse(date);