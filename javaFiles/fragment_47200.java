String commandLineInput = System.getProperty("sun.java.command");
Pattern pattern = Pattern.compile("-Xmx(\\w*)");
Matcher matcher = pattern.matcher(commandLineInput);
while(matcher.find()) {
  System.out.println(matcher.group(1));
}