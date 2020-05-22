BufferedReader fsmReader = new BufferedReader(new FileReader(args[0]));

List<String[]> contentList = new ArrayList<>();
String lines;
while ((lines = fsmReader.readLine()) != null) {
    contentList.add(lines.split(" "));
}

//print the list     
for (String[] content : contentList) {
    System.out.println(Arrays.toString(content));
}