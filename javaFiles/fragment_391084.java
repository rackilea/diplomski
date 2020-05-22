public static int lookup(String wrd) throws IOException {
    int cnt = 0;

    BufferedReader in = new BufferedReader(
        new StringReader(new String("word adfasdword avcasf\n asdf WoRd asdfWORDasdf")));

    String line = in.readLine();
    while (line != null) {
      Pattern ptn = Pattern.compile(wrd, Pattern.CASE_INSENSITIVE);
      Matcher mtch = ptn.matcher(line);
      while (mtch.find()) {
        cnt++;
      }
      line = in.readLine();
    }
    return cnt;
  }

  public static void main(String[] args) throws IOException {
    System.out.println(lookup("WORD"));
    System.out.println(lookup("word"));
    System.out.println(lookup("WorD"));
    System.out.println(lookup("worLd"));
  }