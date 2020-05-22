// Connect to the server and read in file data
byte[] fileData = ...;
DataOutputStream dataOut = new DataOutputStream( outStream );
dataOut.writeInt( fileData.length );
dataOut.write( fileData );
// Get reply from server