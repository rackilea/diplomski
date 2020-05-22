JSONArray jArray=new JSONArray(request.getParameter("ImageData"));
 JSONObject obj;
 JSONParser parser = new JSONParser();
 List<Counter> lstCounter = new ArrayList<Counter>();
 Counter counter = new Counter();

 //Create Loop which iterates your jArray
{
     JSONObject obj = (JSONObject)parser.parse( < jArray[iterator.next()] >  ) //Here you need to parse the each your JSON and convert one by one in jsonobject
     Ex: { "Counter": "Counter A", "Name": "CountA1.jpg", "IsActive.jpg":"Y" } as your first line you can extract the first row.

     //Store the row in Model Counter as a list
     counter = new Coutner();
     counter.setCounter( <read data from json array> );
     //same thing for img and flag then add to lstCounter
    lstCounter.add( counter);
}