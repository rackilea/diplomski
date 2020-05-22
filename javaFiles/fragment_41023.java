ZipFile zipTestData = null;

try {
      zipTestData = new ZipFile(testData)
} catch (IOException io)
  log.debug(io.toString());
} catch(Exception e) {
  log.debug(e.toString());
}

return zipTestData;