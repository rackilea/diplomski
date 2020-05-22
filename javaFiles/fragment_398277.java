// Try-catch omitted for simplicity

PrintStream ps = new PrintStream("some_output_file.txt");
for(int i = 0; i < yourFloatBuffer.capacity(); i++)
{
   // put each float on one line
   // use printf to get fancy (decimal places, etc)
   ps.println(yourFloagBuffer.get(i));
}

ps.close();