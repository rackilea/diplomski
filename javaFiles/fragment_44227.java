// Create ServerSocket and get Client connection
DataInputStream dataIn = new DataInputStream( is );
int length = dataIn.readInt();
byte[] data = new byte[ length ];
dataIn.readFully( data );
// Continue to process client connection