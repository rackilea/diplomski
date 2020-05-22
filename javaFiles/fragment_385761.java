String input = paramJsonParser.getText();
DateFormat inputFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // this has to be like your input
Date date = inputFormatter.parse(input);

DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
String output = outputFormatter.format(date); // Output : yyyy-MM-dd