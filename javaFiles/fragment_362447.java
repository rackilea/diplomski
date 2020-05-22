try
{
    Class<?> c = Class.forName("android.telecom.Call");
    Object instance = c.newInstance();
    Method m = c.getDeclaredMethod("disconnect");
    m.setAccessible(true);
    m.invoke(instance, new Object[] {});
}
catch (Exception e)
{
    Log.e("Exception of Reflection", e.getLocalizedMessage());
}