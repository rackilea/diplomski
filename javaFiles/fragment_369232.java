/** Verify that your strJson string contains this:
 * {
 *   "response":{
 *               "School":"SBOA",
 *               "Name":"Anitha",
 *               "Class":"Tenth",
 *             },
 *               "Result":"Good",
 * }
 */
String strJson = ??;
Log.d("TAG", "strJson: " + strJson);
try {
    JSONObject jsonRootObject = new JSONObject(strJson);
    JSONObject response = jsonRootObject.getJsonObject("response");
    String schoolString = response.getString("School");
    String nameString = response.getString("Name");
    String classString = response.getString("Class");

    String result = jsonRootObject.getString("Result");
} catch(JSONException e) {
    Log.e("TAG", "Error reading json: " + jsonRootObject.toString());
}