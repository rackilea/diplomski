int lineCount = 1;
while((line = reader.readLine()) != null)
{
  if (lineCount == 2)
    oldText += parseCommand.replaceFirst("\\w*( ?)", "hen\1")
      + System.lineSeparator();
    //oldText += "hen" + System.lineSeparator();
  else
    oldtext += line + System.lineSeparator();
  lineCount++;
}