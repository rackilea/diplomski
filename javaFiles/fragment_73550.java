ObjectMapper mapper = new ObjectMapper();
Point coors = null;
 try {
     MyPoint mine = mapper.readValue(str, MyPoint.class);
     coors = mine.point;
} catch (JsonParseException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (JsonMappingException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}