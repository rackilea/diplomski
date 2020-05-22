final JSONObject myObject = paramObj.getJSONObject(X);
final JSONArray myArray = myObject.getJSONArray(VALUE);
if (myArray != null)
{
    myList.forEach(code -> {
        if (myCondition.equalsIgnoreCase(TEST))
        {
            while(myArray.length() > 0)
            {
                myArray.remove(0);
            } 
            myArray.put(code);
        }
        else
        {
            myArray.put(code);
        }
    });
}