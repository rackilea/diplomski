public CompletionStage<String> transformLine()
{
  return readLine().thenApply(line ->
    Completions.wrapExceptions(() ->
    {
      if (line.contains("%"))
        throw new IOException("Lines may not contain '%': " + line);
      return "transformed: " + line;
    }));
}