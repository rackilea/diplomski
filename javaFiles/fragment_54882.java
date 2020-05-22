public static int getStringIdentifier(Context context, String name) {
    return getResources().getIdentifier(name, "string", 
        getPackageName());
}


getResources()
 .getString(getStringIdentifier(getApplicationContext(),loc_key));