while (scan.hasNextLine()) {
  Scanner input = new Scanner(scan.nextLine());
  input.useDelimiter(",");
  while (input.hasNext()) {
    String md5 = input.next();
    temp.add(md5);
  }
}