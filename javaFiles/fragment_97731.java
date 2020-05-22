List<TextPositionSequence> findSubwords(PDDocument document, int page, String searchTerm) throws IOException
{
    final List<TextPositionSequence> hits = new ArrayList<TextPositionSequence>();
    PDFTextStripper stripper = new PDFTextStripper()
    {
        @Override
        protected void writeString(String text, List<TextPosition> textPositions) throws IOException
        {
            TextPositionSequence word = new TextPositionSequence(textPositions);
            String string = word.toString();

            int fromIndex = 0;
            int index;
            while ((index = string.indexOf(searchTerm, fromIndex)) > -1)
            {
                hits.add(word.subSequence(index, index + searchTerm.length()));
                fromIndex = index + 1;
            }
            super.writeString(text, textPositions);
        }
    };

    stripper.setSortByPosition(true);
    stripper.setStartPage(page);
    stripper.setEndPage(page);
    stripper.getText(document);
    return hits;
}