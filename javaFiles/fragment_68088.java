final String fileName = "E:\\info.txt";
String everything = "";

try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
  StringBuilder sb = new StringBuilder();
  String line = br.readLine();

  while (!(line.equals("ef"))) {
    sb.append(line).append("\n");
    // sb.append(System.lineSeparator());
    line = br.readLine();
  }

  sb.append(line);
  everything = sb.toString();
  System.out.print(everything);
}

final File file = new File(fileName);
file.delete();

try (FileWriter writer = new FileWriter(fileName)) {
  writer.write(everything);
}