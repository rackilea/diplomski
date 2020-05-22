int countLines(dir, string)  // the string could be an instance variable, also, and not passed in
{
  var countedLines = 0;
  for each item in dir:
    if item is file, countedLines += matchedLinesInFile(item, string);
    else if item is dir, countedLines += countLines(item, string);
    else throw up;  // or throw an exception -- your choice
}