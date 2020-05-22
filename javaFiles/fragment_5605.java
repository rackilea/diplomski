socket.setSoTimeout(30 * 1000);                  // timeout after 30 seconds

try
{
  while ((readChar=readSocket.read()) != -1)     // block reading data ...
  {
    // processing ...
  }
}
catch (SocketTimeoutException e)                 // we didn't get any data within 30 seconds ...
{
  socket.close();                                // ... close the socket
}