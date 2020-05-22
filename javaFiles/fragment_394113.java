try
{
   while (true) 
   {
      System.out.print("input: ");
      userInput = stdIn.readLine();
      if (userInput == null) break;
      out.println(userInput);

      System.out.println(in.readLine());
      System.out.println(in.readLine());

      if (userInput.equals("Bye."))
      {
          System.out.println("Exit program");
          break;        
    }
    getValueLog(parseFixMsg(userInput,userInput));
 }
}
catch (Exception e)
{
   e.printStackTrace();
}
finally
{
    // any of these lines could raise an exception as well.
    out.close();
    in.close();
    stdIn.close();
    echoSocket.close();
 }