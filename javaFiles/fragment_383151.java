Scanner sc = new Scanner(System.in);
List<String> list = new ArrayList<String>();

while (sc.hasNext()) {
    String s = sc.next();
    if (s.equalsIgnoreCase("stop")) {
        break;
    } else {
        list.add(s);
    }
}

for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i) + ",");
}