public static void main(String[] args) {
    String str = "{\"type\":\"Point\",\"coordinates\":[-397408.355686851020437,7575590.819041009992361]}";

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
     System.out.println(coors);
}