private void bindDocumentReaders(Class<? extends DocumentReader>... types) {
  for (Class<? extends DocumentReader> type : types) {
    FileType[] supportedFileTypes = type.getAnnotation(SupportedFileTypes.class)
        .filetypes();
    // add to MapBinder for each file type
  }
}