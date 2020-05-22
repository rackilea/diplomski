public static String[] parseStringArrayFromJSONArray(String jsonArray)
{
    String[] stringArray = null;
    try
    {
        JSONArray array = new JSONArray(jsonArray);
        if (array != null)
        {
            stringArray = new String[array.length()];

            for (int i = 0; i < array.length(); i++)
            {
                stringArray[i] = array.getString(i);
            }
        }
    } catch (Exception e)
    {
        stringArray = null;
    }

    return stringArray;
}