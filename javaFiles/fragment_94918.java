try
{
    int itemId = R.raw.class.getField(name).getInt(null);
    InputStream is = getResources().openRawResource(itemId);
    InputStreamReader isreader = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isreader);
} 
catch (NoSuchFieldException ex)
{
    // Handle
}
catch (IllegalAccessException ex)
{
    // Handle
}