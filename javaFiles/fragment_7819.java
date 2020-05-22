Object obj = new org.json.JSONTokener(input).nextValue();
if (obj instanceof JSONArray)
    return "JSONArray";

if (obj instanceof JSONObject)
    return "JSONObject";

if (obj instanceof Integer)
    return "Integer"
...