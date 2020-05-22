public void inspectPdf(String filename) throws IOException, DocumentException {
    PdfReader reader = new PdfReader(filename);
    List<HashMap<String,Object>> bookmarks = SimpleBookmark.getBookmark(reader);
    for (int i = 0; i < bookmarks.size(); i++){
        showTitle(bookmarks.get(i));
    }
    reader.close();
}

public void showTitle(HashMap<String, Object> bm) {
    System.out.println((String)bm.get("Title"));
    List<HashMap<String,Object>> kids = (List<HashMap<String,Object>>)bm.get("Kids");
    if (kids != null) {
        for (int i = 0; i < kids.size(); i++) {
            showTitle(kids.get(i));
        }
    }
}