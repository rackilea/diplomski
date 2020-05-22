try {
      notifications=new JSONArray(obj.toString());
        } catch(JSONException e)
        {
            Toast.makeText(context," SORRY NO INTERNET CONNECTION "
                Toast.LENGTH_SHORT).show();}