try {

   JSONArray jr = new JSONArray("Your json string");
   JSONObject jb = (JSONObject)jr.getJSONObject(0);
   JSONArray st = jb.getJSONArray("streets");
   for(int i=0;i<st.length();i++)
       {
      String street = st.getString(i);
      Log.i("..........",""+street);
      // loop and add it to array or arraylist
        }
}catch(Exception e)
{
        e.printStackTrace();
}