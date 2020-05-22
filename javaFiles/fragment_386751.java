String comm = "/*";
BufferedReader br = new BufferedReader(new FileReader(FILENAME););

StringBuilder sb = new StringBuilder();
String currentLine;

while ((currentLine = br.readLine()) != null && !(currentLine.equals(comm)) {
    //System.out.println(currentLine);
    sb.append(currentLine);
    sb.append("\n");
}
br.close();
System.out.println(sb.toString());