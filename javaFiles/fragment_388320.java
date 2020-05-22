PDDocument document = PDDocument.load(PDFRESOURCE, null);
PDPage page = document.getPage(PAGENUMBER);
ClipPathFinder finder = new ClipPathFinder(page);
finder.findClipPaths();

for (Path path : finder)
{
    System.out.println(path);
}

document.close();