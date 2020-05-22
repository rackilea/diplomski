while ((lineContents = tempFileReader.readLine()) != null)
{
    String lineByLine = lineContents.replaceAll("/\\.", System.getProperty("line.separator")); //for matching /. and replacing it by new line
    changer.write(lineByLine);
    Pattern pattern = Pattern.compile(".*\\r?\\n"); //Find new line
    Matcher matcher = pattern.matcher(lineByLine);
    while(matcher.find())
    {
        Pattern tagFinder = Pattern.compile("word"); //Finding the word required
        //matcher.group() returns the input subsequence matched by the previous match.
        Matcher tagMatcher = tagFinder.matcher(matcher.group());
        while(tagMatcher.find())
        {
            score++;
        }
        scoreTracker.add(score);
            score = 0;
    }   
}