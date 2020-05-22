ArrayList<String[]> tmp = new ArrayList<String[]>();
String line;
while ((line = br.readLine()) != null) {
    tmp.add(line.split(" ");
}
String[][] maze = tmp.toArray(new String[tmp.length()][]);