while (scan.hasNextLine()) {
  Scanner input = new Scanner(scan.nextLine());
  input.useDelimiter(",");
  while (scan.hasNext()) {
    String md5 = scan.next();
    temp.add(md5);
  }
}