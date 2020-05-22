public abstract class SuperClass {
    public int x, y;
    private static Map<Class,Integer> zs = new HashMap<Class,Integer>();
    protected static int getZ(Class c) {
        Integer res = zs.get(c);
        return res == null ? -1 : res.intValue();
    }
    protected static void setZ(Class c, int v) {
        zs.put(c, v);
    }
}
class SubClassOne extends SuperClass {
    public int getZ() {
        return SuperClass.getZ(SubClassOne.class);
    }
}
class SubClassTwo extends SuperClass {
    public int getZ() {
        return SuperClass.getZ(SubClassTwo.class);
    }
}