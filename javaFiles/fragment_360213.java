List<String> itemList = new ArrayList<>();
for (int i = 0; i < lines.length; i++) {
    for (String token : lines[i].split(";")) {
        itemList.add(token);
    }
}
System.out.println(itemList);