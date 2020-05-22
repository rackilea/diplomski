private void appendAlbum(Element rootElement, String titleStr, String id, String artistStr, String yearStr) {
    Element album = doc.createElement("Album");
    rootElement.appendChild(album);

    //Set attribute to album element
    Attr attr = doc.createAttribute("ID");
    attr.setValue(id);
    album.setAttributeNode(attr);

    //Title elements
    Element title = doc.createElement("Title");
    title.appendChild(doc.createTextNode(titleStr));
    album.appendChild(title);

    //Artist elements
    Element artist = doc.createElement("Artist");
    artist.appendChild(doc.createTextNode(artistStr));
    album.appendChild(artist);

    //Year elements
    Element year = doc.createElement("Year");
    year.appendChild(doc.createTextNode(yearStr));
    album.appendChild(year);
}