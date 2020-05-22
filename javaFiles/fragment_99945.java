String[] lines = str.split("\n");
 String[] header = lines[0].split("\\s?,\\s?");

 List< String[] > data = new ArrayList< String[] >();
 for ( int i=1; i<lines.length; i++ ) {
     data.add( lines[i].split("\\s?,\\s?") );
 }