while (!shutdown)
{
  try
  {
    // some method that calls your read and parses the message.
    code = readData();
    if (code == null) continue; 
  }
  catch (SocketTimeoutException ste)
  {
    // A SocketTimeoutExc. is a simple read timeout, just ignore it.
    // other IOExceptions will not be stopped here.
  }
}