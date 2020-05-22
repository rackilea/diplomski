FontFactory.register(args[2], "jakiesFonty");
Font font = FontFactory.getFont("jakiesFonty", BaseFont.CP1250, BaseFont.EMBEDDED);
BaseFont bf = font.getBaseFont();
fnt12n = new Font(bf, 12f, Font.NORMAL, BaseColor.BLACK);
// PDF
outputW.setPdfVersion(PdfWriter.VERSION_1_7);
pdf.addTitle("Musical collection");
pdf.addAuthor("Natalia Nazaruk");
pdf.addSubject("Cwiczenie tworzenia PDF z XML");
pdf.addKeywords("Metadata, Java, iText, PDF");
pdf.addCreator("Program: MusicXML");
pdf.setMargins(60, 60, 50, 40);
pdf.open();
List<Artist> listaArtystow = music.getArtist();
for (Artist artysta : listaArtystow) {
    ...
    for (Album album : listaAlbumow) {
        ...
        for (Song piosenka : listaPiosenek) {
            ...
            pdf.newPage();
            ...
        }
    }
}
pdf.close();