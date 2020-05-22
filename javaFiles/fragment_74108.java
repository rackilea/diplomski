public static String getGlassSerial(Context context) {
  String prop="ro.serialno.glass";
  String result=null;
  try{
    Class SystemProperties =
      context.getClassLoader().loadClass("android.os.SystemProperties");

    Class[] paramtypes=new Class[1];
    paramtypes[0]=String.class;
    Object[] paramvalues=new Object[1];
    paramvalues[0]=new String(prop);      
    Method get=SystemProperties.getMethod("get", paramtypes);

    result=(String) get.invoke(SystemProperties, paramvalues);
  } catch(Exception e) {
    result=null;
  }
  return result;
}