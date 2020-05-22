public class MyLibrary {
    public static String init( Context context ) {
        try {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo( context.getPackageName(), PackageManager.GET_META_DATA );
            return (String)ai.metaData.get( "my_app_id" );
        } catch ( PackageManager.NameNotFoundException e ) {
            //TODO: handle exception
        }
...
}