int v = 2;
int w = 4;
String q = "a";
List<String> list = new ArrayList<>();
StringBuilder sb = new StringBuilder();
for (int i = 0; i < v; i++) {
    sb.append(q);
}
for (int j = v; j <= w; j++) {
    list.add(sb.toString());
    sb.append(q);
}
System.out.println(list);