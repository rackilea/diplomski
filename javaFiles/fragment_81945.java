private String generateFileID () {
   CustomFile file = new CustomFile();
   String generatedValue = RandomStringUtils.randomAlphanumeric(5);
   while (fileIdMap.putIfAbsent(generatedValue, file) != null) {
       generatedValue = RandomStringUtils.randomAlphanumeric(5);
   }
   return generatedValue;
}