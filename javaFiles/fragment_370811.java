class PDFParserTextStripper extends PDFTextStripper {

    public PDFParserTextStripper() throws IOException {
        super();
    }


    public void stripPage(int pageNr) throws IOException {
        this.setStartPage(pageNr+1);
        this.setEndPage(pageNr+1);
        Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
        writeText(document,dummy); // This call starts the parsing process and calls writeString repeatedly.
    }



    @Override
    protected void writeString(String string,List<TextPosition> textPositions) throws IOException {
        for (TextPosition text : textPositions) {
            System.out.println("String[" + text.getXDirAdj()+","+text.getYDirAdj()+" fs="+text.getFontSizeInPt()+" xscale="+text.getXScale()+" height="+text.getHeightDir()+" space="+text.getWidthOfSpace()+" width="+text.getWidthDirAdj()+" ] "+text.getUnicode());
        }
    }

}