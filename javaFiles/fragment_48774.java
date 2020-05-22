public String connect()
{
   String errorMessage = null;
   tcConnectionHandle = new TelnetClient();
   tcConnectionHandle.setDefaultTimeout(iTimeOutMilliseconds);
   tcConnectionHandle.registerInputListener(this);

   try
   {
      tcConnectionHandle.connect(strConnectionIP, intConnectionPort);
      osOutput = tcConnectionHandle.getOutputStream();
      isInput = tcConnectionHandle.getInputStream();
   }
   catch(SocketException sX)
   {
      errorMessage = sX.getMessage();
   }
   catch(IOException ioX)
   {
      errorMessage = ioX.getMessage();
   }

   return errorMessage;
}

public Matcher waitForRegularExpression(String regularExpression)
{
   Matcher matcher;
   Pattern pattern = Pattern.compile("(?s)" + regularExpression);
   StringBuilder warningLog = new StringBuilder();

   synchronized(sbInputBuffer)
   {
      matcher = pattern.matcher(sbInputBuffer.toString());

      while(!matcher.find())
      {
         try
         {
            int inputBufferSize = sbInputBuffer.length();
            sbInputBuffer.wait(iTimeOutMilliseconds);

            if(inputBufferSize == sbInputBuffer.length())
            {
               warningLog.append("Did not find pattern and no new input.");
               logWarning(warningLog.toString());
               return null;
            }
         }
         catch(InterruptedException intX)
         {
            warningLog.append("Interrupted waiting on input. ").append(intX.getLocalizedMessage());
         }

         matcher = pattern.matcher(sbInputBuffer.toString());
      }

      sbInputBuffer.delete(0, matcher.end()-1);
   }

   if(!warningLog.toString().isEmpty())
   {
      logWarning(warningLog.toString());
   }

   return matcher;
}

@Override
public void telnetInputAvailable()
{
   synchronized(sbInputBuffer)
   {
      StringBuilder warningLog = new StringBuilder();
      int readBytes = -2;

      if(isInput != null)
      {
         try
         {
            readBytes = isInput.read();

            if(readBytes > 0)
            {
               sbInputBuffer.append((char)readBytes);
            }

            sbInputBuffer.notify();
         }
         catch(IOException ioX)
         {
            warningLog.append("Failed for IO: ").append(ioX.getLocalizedMessage()).append(" - input so far: ")
               .append(sbInputBuffer.toString()).append("\nRead bytes: ").append(readBytes).append("\n");
            logWarning(warningLog.toString());
         }
      }
   }
}