void printSubwords(PDDocument document, String searchTerm) throws IOException
{
    System.out.printf("* Looking for '%s'\n", searchTerm);
    for (int page = 1; page <= document.getNumberOfPages(); page++)
    {
        List<TextPositionSequence> hits = findSubwords(document, page, searchTerm);
        for (TextPositionSequence hit : hits)
        {
            TextPosition lastPosition = hit.textPositionAt(hit.length() - 1);
            System.out.printf("  Page %s at %s, %s with width %s and last letter '%s' at %s, %s\n",
                    page, hit.getX(), hit.getY(), hit.getWidth(),
                    lastPosition.getUnicode(), lastPosition.getXDirAdj(), lastPosition.getYDirAdj());
        }
    }
}