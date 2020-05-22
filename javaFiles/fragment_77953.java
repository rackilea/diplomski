String line = scanner.nextLine();

//this will ignore empty lines
if(line.equals("")) continue;

String[] lineArray = line.split(" ");
String studentId = lineArray[0];
int mark = Integer.parseInt(lineArray[1]);