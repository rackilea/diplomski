public class LoaderHelper {
    public static String getJson(Context context, String json){
        String jsonString=parseFileToString(context, json);
        return jsonString;
    }
    public static String parseFileToString( Context context, String filename )
    {
        try
        {
            InputStream stream = context.getAssets().open( filename );
            int size = stream.available();

            byte[] bytes = new byte[size];
            stream.read(bytes);
            stream.close();

            return new String( bytes );

        } catch ( IOException e ) {
            Log.i("GuiFormData", "IOException: " + e.getMessage() );
        }
        return null;
    }
}