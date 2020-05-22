//change return type to string
    public static String WriteBirdType() {

    BufferedReader reader = new BufferedReader( new FileReader ("fugler.txt"));
    String         line = null;
    StringBuilder  stringBuilder = new StringBuilder();
    String         ls = System.getProperty("line.separator");

    while( ( line = reader.readLine() ) != null ) {
    stringBuilder.append( line );
    stringBuilder.append( ls );
    }

     return stringBuilder.toString();