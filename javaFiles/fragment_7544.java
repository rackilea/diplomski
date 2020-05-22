String[] files = { MovieLinks1.RESULT, MovieHistory.RESULT };
// step 1
Document document = new Document();
// step 2
PdfCopy copy = new PdfCopy(document, new FileOutputStream(RESULT));
// step 3
document.open();
// step 4
PdfReader reader;
int n;
// loop over the documents you want to concatenate
for (int i = 0; i < files.length; i++) {
    reader = new PdfReader(files[i]);
    // loop over the pages in that document
    n = reader.getNumberOfPages();
    for (int page = 0; page < n; ) {
        copy.addPage(copy.getImportedPage(reader, ++page));
    }
    copy.freeReader(reader);
    reader.close();
}
// step 5
document.close();