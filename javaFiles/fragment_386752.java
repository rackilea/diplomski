StringBuilder sb = new StringBuilder();
Scanner sc = new Scanner(FILENAME);

while (sc.hasNext())
    sb.append(sc.next());
System.out.println(sb.toString());