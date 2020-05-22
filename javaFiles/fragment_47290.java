String line = input.nextLine();

String[] values = line.split(" ");

String firstName = values[0];
String secondName = values[1];
String libraryNumber = values[2];
total += Integer.parseInt(values[3]);

output.println(line);