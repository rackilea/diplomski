String line = value.toString();
String[] tokens = line.split(",");
String[] date = tokens[2].split("-");
String year = date[0];
String location = tokens[0];

Text locationYear = new Text(location + " " + year);