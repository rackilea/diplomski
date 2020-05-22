String str = "(a,b=7)";

Pattern p = Pattern.compile("\\((.*?),(.*?)=(\\d+)\\)");
Matcher m = p.matcher(str);
if (m.matches()) {
    System.out.println(m.group(1));                    // a
    System.out.println(m.group(2));                    // b
    System.out.println(Integer.parseInt(m.group(3)));  // 7
}