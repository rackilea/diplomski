String st = "'test1, test2','test3, test4',test5,'test6, test7',test8";
Pattern p = Pattern.compile("('[^']*'|[^,]*)(?:,?)");
Matcher m = p.matcher(st);
while (m.find()) {
    System.out.println(m.group(1));
}