public static byte[] incomingBytes = new byte[44];

public void run(){
            //byte [] buffer replaced with incomingBytes
            byte[] buffer = new byte[44];  // this was in the example, but it is not used. It was replaced by incomingBytes, declared at the start of the class

            int bytes; // bytes returned from read()

            // Keep listening to the InputStream until an exception occurs
            while (true) {
                // Read from the InputStream
                try {
                    bytes = mmInStream.read(incomingBytes);
                    incomingMessage = new String(incomingBytes, 0, bytes);
                    Log.d(TAG, "InputStream: " + incomingMessage);
                } catch (IOException e) {
                    Log.e(TAG, "write: Error reading Input Stream. " + e.getMessage() );
                    break;
                }
            }
        }