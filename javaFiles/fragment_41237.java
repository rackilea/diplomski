public String ReadJsonFromFile(String fileName){
    JSONParser parser = new JSONParser();
    String firstRecord = null;
    try {
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(fileName));
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);  
        firstRecord = jsonObject.toString();

    } catch (FileNotFoundException e) {
        LOG.info("JSON -> Can't read from file: File Not Found");
        e.printStackTrace();
    } catch (IOException e) {
        LOG.info("JSON -> Can't read File : IO Exception");
        e.printStackTrace();
    } catch (ParseException e) {
        LOG.info("JSON -> Can't Parse JSON in File");
        e.printStackTrace();
    }

    return firstRecord;

}