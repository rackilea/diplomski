String test = "#";
int beginIndex = test.indexOf("#");
test = test.substring(beginIndex+1);
String[] allCommands = test.split("#");
System.out.println("allCommands length: " + allCommands.length); // output: 1
System.out.println(allCommands[0].length());
System.out.println("allCommands array: " + Arrays.toString(allCommands));