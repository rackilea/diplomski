File[] files = parentFolder.list();
 StringBuilder veryVeryBigBuilder = new StringBuilder();
 for (File file: files) {
   if (isXmlFile(file)) {
      veryVeryBigBuilder.append(FileUtils.readFileToString(), encoding);
   }
 }