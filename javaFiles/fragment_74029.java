public CompletionStage<String> readLine()
{
  return Completions.supplyAsync(() ->
  {
    try (BufferedReader br = new BufferedReader(new FileReader("test.txt")))
    {
      return br.readLine();
    }
  });
}