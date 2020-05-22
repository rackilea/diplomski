List<StringBuilders> list = new ArrayList<>();
String str = '...';
String[] parsedLine = str.split("\\n");
for(int i = 0; i < parsedLine.length;i++) {
    if(list.size() <= i) list.add(new StringBuilder());

    list.get(i).append(parsedLine + "\t");
}

for(StringBuilder sb : list) {
    System.out.println(sb.toString());
}