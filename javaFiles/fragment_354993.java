public static void writeStringToPreference(Context context,String tag,String    value)
  {
     SharedPreferences sharedP = context.getSharedPreferences(nameSpace, O);
     Editor editor=sharedP.edit();
     editor.putString(tag,value)
     editor.commit();
  }

public static String readStringToPreference(Context context,String tag)  {
  SharedPreferences sharedP = context.getSharedPreferences(nameSpace, O);
  return sharedP.getString(tag);
 }