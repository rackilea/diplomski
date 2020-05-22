public static List<String> readLinesFromFile() {
  List<String> lines = new ArrayList<String>();
  try {
     // !! scanner = new Scanner(new File("upload.txt"));
     scanner = new Scanner(new File(UPLOAD_TXT));
     if (scanner.hasNext()) {
        lines.add(scanner.nextLine());
     }
  } catch (FileNotFoundException e) {
     e.printStackTrace();
  }

  System.out.println(lines); // ***** I added this
  return lines;
}