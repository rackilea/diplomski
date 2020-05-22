// on the server
public void doWork(String jsonString) {
    ObjectMapper jsonHelper = new ObjectMapper();
    ObjectReader reader = jsonHelper.reader(new TypeReference<MyObject>() {});
    MyObject actualHardObject;
    try {
      actualHardObject = reader.readValue(jsonString);
    } catch (IOException e) {
      log.severe("Couldn't parse json param: " + e.getMessage());
    }

    // do whatever you want with actualHardObject now
}