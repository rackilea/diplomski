// "query" is the top-level object: 
JSONObject query = json.getJSONObject("query");
// "pages" is a field of "query"
JSONObject pages = query.getJSONObject("pages");

// these will hold the object with the value that you want, and that value:
JSONObject nestedObject = null;
int pageId = 0;

// these are the property names in the "pages" object:
String[] keys = pages.getNames(pages);

// iterate over the keys in the "pages" object, looks for JSONObjects:
for (int i = 0; i < keys.length; i++)
{
    try
    {
        nestedObject = pages.getJSONObject(keys[i]);
        // only consider objects with a "pageid" key, stop at the first one:
        if (nestedObject.has("pageid"))
            break;
    }
    catch (JSONException je)
    { ; }
}

if (nestedObject != null)
   pageId = nestedObject.getInt("pageid");