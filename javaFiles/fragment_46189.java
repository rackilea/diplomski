String[] lines = input.split("<end>");
for(String line : lines)
{
    line = line.trim();
    String[] sublines = line.split("<");
    for(String subline : sublines)
    {
        subline = subline.trim();
        ...additional breaking, trimming, branching...
    }
}