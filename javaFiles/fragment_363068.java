StringBuilder jsonStringBuilder = new StringBuilder(); 

// display profile data in EditText
try 
{
    jsonStringBuilder.append(product.getString(TAG_LATITUDE));
    jsonStringBuilder.append(", ");                                
    jsonStringBuilder.append(product.getString(TAG_LONGITUDE));
    lblDummyLocation.setText(jsonStringBuilder.toString());            
} 
catch (JSONException e) 
{
    e.printStackTrace(); // use a logger for this ideally
    lblDummyLocation.setText("Failed to get co-ordinates");            
}