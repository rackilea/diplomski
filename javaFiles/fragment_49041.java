String data = "==SOME_ID== - item 1 - item 2 - item 3 .. item 100 == SOME_ID_2 == - item 1 - item 2 - item 3 ... item 100 == SOME_ID_3 == ...";
Pattern p = Pattern.compile("==([^=]+)==([^=]+)(?=(?:=|$))");
    Matcher m = p.matcher(data);
while (m.find()) {
    System.out.println("ID="+m.group(1));
    System.out.println("Data="+m.group(2));
}