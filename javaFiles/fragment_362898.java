String[] data = new String[] {
    "BOWLING O M R W ECON 0s 45 6", //notice that your OCR software does not properly recognise the string here
    "TABoult 4 0 3 0 925 M 2 3",
    "JETED 6 0 = 4 O 0 0"
};

BufferedWriter writer = new BufferedWriter( new FileWriter( System.getProperty( "user.home" ) + System.getProperty( "file.separator" ) + "data.csv"  ) );

for( String record : data ) {
    writer.write( record.replaceAll( " ", ";" ) );
    writer.write( "\n" );
}
writer.close();