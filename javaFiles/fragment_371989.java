public class JSONtest
{

    @Test
    public void test() throws JSONException
    {
        JSONArray array = new JSONArray();

        JSONObject im = new JSONObject();       
        toJSON(im, "Ok", "image1.bmp");
        array.put(im);

        im = new JSONObject();      
        toJSON(im, "Ok", "image2.bmp");
        array.put(im);

        im = new JSONObject();      
        toJSON(im, "Ok", "image3.bmp");
        array.put(im);

        System.out.println(array.toString());
    }

    public void toJSON(JSONObject outer,String description, String imageName)
    {
      JSONObject inner = new JSONObject();
      try 
      { 
        outer.put(imageName, inner);
        inner.put("description", description);
        inner.put("filename", imageName);
      } 
      catch (JSONException ex) { ex.printStackTrace(); }
    }

}