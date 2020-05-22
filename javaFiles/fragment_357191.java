ZipEntry entry = zipFile.getEntry(entryName);
    InputStream xmlInStream = zipFile.getInputStream(entry);
            //process the stream- below one is for xml parsing.
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
    return documentBuilder.parse(xmlInStream);