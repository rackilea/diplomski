Scanner in = new Scanner(reader);
try{
    while (in.hasNextLine()) {
      String line = in.nextLine();
      out.println(line);
    }
} finally {
    in.close();
    out.close();
}