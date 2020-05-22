private String computeSomething(String commandName,String memLocation,String dataId) {
  int  commandValue = commandMap.get(commandName);
  int  dataValue    = dataIdMap.get(dataId);
  byte memValue     = locationMap.get(memLocation)).getBytes()[0];
  return Integer.toHexString(commandValue + dataValue + memValue);
}