Scanner sc = new Scanner(System.in);
String line = "";

while (sc.hasNext()) {
    String s = sc.next();
    if (s.equalsIgnoreCase("stop")) {
        break;
    } else {
        line += s + ", ";
    }
}

System.out.println(line.substring(0, line.length()-2));