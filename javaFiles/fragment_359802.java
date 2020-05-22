final DocumentFormat format =
    DocumentFormat.builder()
        .from(DefaultDocumentFormatRegistry.HTML)
        .storeProperty(DocumentFamily.TEXT, "FilterOptions", "EmbedImages")
        .build();

LocalConverter
    .make()
    .convert(new FileInputStream(docFile))
    .as(DefaultDocumentFormatRegistry.getFormatByMediaType(file.getMediaType().getName()))
    .to(htmlTempFile)
    .as(format)
    .execute();