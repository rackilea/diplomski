String s = "3894$75\\/^()";
String text = "fdsfsd3894$75\\/^()dasdasd 22348 3894$75\\/^()";
Matcher m = Pattern.compile("(?<=^|\\s)\\Q" + s + "\\E(?=\\s|$)").matcher(text);
while (m.find()) {
    System.out.println("Found match! :'" + m.group() + "'");
}