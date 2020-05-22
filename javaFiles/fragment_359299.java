// send a message to the server
while (running)
{
    // receive a response
    if (secure)
    {
      // ... some code here
    }
    else
    {
      // !CHANGES HERE!
      byte[] bytes = readTillTimeout(in);
      decodeMessage(bytes);
    }
}