public void addWorkDetails(ArrayList<SearchResults> listItems, final long id)
{
    JSONArray jsonArray = new JSONArray();
    try
    {
        for (SearchResults s : listItems)
        {
            JSONObject object= new JSONObject();
            object.put("project", s.getProject());
            object.put("work_description", s.getDescription());
            object.put("percentage", s.getProgress());
            object.put("timeIn", s.getTimeIn());
            object.put("timeOut", s.getTimeOut());
            object.put("twf", String.valueOf(id));
            jsonArray.put(object);
        }
    }catch(JSONException e)
    {
        e.printStackTrace();
    }

    AddWorkDetails ru = new AddWorkDetails(jsonArray);
    ru.execute(); 
}