while (scan.hasNextLine()) {
  String line = scan.nextLine();
  String[] tokens = line.split(",");
  for (String token: tokens) {
    temp.add(token);
  }
}