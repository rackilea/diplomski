//getting whole json string
JSONObject jsonObj = new JSONObject(jsonStr);

//extracting data array from json string
JSONArray ja_data = jsonObj.getJSONArray("data");
int length = jsonObj .length(); 

//loop to get all json objects from data json array
for(int i=0; i<length; i++) 
{
    JSONObject jObj = ja_data.getJSONObject(i);
    Toast.makeText(this, jObj.getString("Name").toString(), Toast.LENGTH_LONG).show();

    // getting inner array Ingredients
    JSONArray ja = jObj.getJSONArray("Ingredients");
    int len = ja.length();

    // getting json objects from Ingredients json array
    for(int j=0; j<len; j++)
    {
        JSONObject json = ja.getJSONObject(j);
        Toast.makeText(this, json.getString("name").toString(), Toast.LENGTH_LONG).show();
    }
}