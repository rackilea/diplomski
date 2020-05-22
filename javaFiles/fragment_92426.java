connectionURL = "btspp://localhost: " + uuid + ";name=control";
bluetoothConnection.open(url);

while (true) {
   // waits on this line until something tries to connect to it.
   bluetoothConnection.acceptAndOpen();

   /* Process control information */
}