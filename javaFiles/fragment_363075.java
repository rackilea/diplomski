public class ValueGetter {
    public static Object[] getValues(Class<? extends Enum> enu) throws Exception {
        Method method = enu.getMethod("values");
        return (Object[]) method.invoke(null);
    }
}