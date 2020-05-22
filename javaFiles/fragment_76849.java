String uname="";
    String pass="";
    BufferedReader reader = request.getReader();
    StringBuilder myinputholder = new StringBuilder();
    String line = null;
    while ((line = reader.readLine()) != null) {
        myinputholder.append(line);
    }

    Integer s= myinputholder.length();

    String ss= myinputholder.toString();
    String sss= ss.substring(1, s-1); // this is to avoid the beginning and end "{}"
    sss=sss.replace("\\", ""); \\ this line is to replace all \ with space
    ObjectMapper mapper = new ObjectMapper();
    JsonFactory factory = mapper.getJsonFactory();
    JsonParser jp = factory.createJsonParser(sss);
    JsonNode actualObj = mapper.readTree(jp);
    JsonNode subnode= actualObj.path("username");
    JsonNode subnode2= actualObj.path("password");
    uname= subnode.getTextValue();
    pass=actualObj.get("password").getTextValue();