public static String changeCase( String s ) {
    boolean capitalize = true;
    int len = s.length();
    char[] output = new char[len];
    for( int i = 0; i < len; i++ ) {
      char input = s.charAt(i);
      if ( input == '\n' ) {
        capitalize = true;
        output[i] = input;
      } else if ( input == '=' ) {
        capitalize = false;
        output[i] = input;
      } else {
        output[i] = capitalize ? Character.toUpperCase(input) : input;
      }
    }
    return new String(output);
}