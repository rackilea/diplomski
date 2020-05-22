public static void badFunctionCall()
{
  new FileNotFoundException("The file could not be found!").printStackTrace();
}

public static void main(String[] args) throws IOException
{
  PipedOutputStream writer = new PipedOutputStream();
  PipedInputStream reader = new PipedInputStream(writer);
  PrintStream p = new PrintStream(writer);
  System.setErr(p);

  badFunctionCall();

  p.close(); // do this *before* reading the input stream to prevent deadlock
  int c;
  StringBuilder builder = new StringBuilder();
  while ((c = reader.read()) != -1)
     builder.append((char)c);
  if (builder.toString().contains("java.io.FileNotFoundException: "))
     System.out.println("An error occurred! Caught outside function.");
  reader.close();
}