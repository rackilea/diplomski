BufferedReader reader = new BufferedReader(new InputStreamReader(System.in,
  Charsets.UTF_8));
// okay, I guess Charsets.UTF_8 is Guava, but that lets us not worry about
// catching UnsupportedEncodingException
while (reader.ready()) {
  String line = reader.readLine();
}