public boolean isJSONValid(String test)
{
    boolean valid = false;
    try {
        new JSONObject(test);
        valid = true;
    }
    catch(JSONException ex) { 
        valid = false;
    }
    return valid;
}