public void doService() throws IOException
{
  while(listening)
  {
    if(inputStreamReader.hasNext())
    {
      String request = inStreamScanner.next();
      outStreamPrinter.println("Request received: " +request);
      outStreamPrinter.flush();
      handleServerRequest(request);
    }
  }
}