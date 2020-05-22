ObjectMapper mapperObj = new ObjectMapper();
String jsonStr = StringUtils.EMPTY;

try {
    jsonStr = mapperObj.writeValueAsString(<<MAP OBJECT>>);
}
 catch (IOException e) { 
 e.printStackTrace();
}