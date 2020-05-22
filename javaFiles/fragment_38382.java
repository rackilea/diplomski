public static void main(String[] args) {
    List<Class<? extends Father>> children =
            Arrays.asList(Child1.class, Child2.class);
    for (Class<? extends Father> c: children) {
        try {
            Method pred = c.getDeclaredMethod("predicate");
            Boolean b = (Boolean) pred.invoke(null);
            if (b.booleanValue()) {
                Father f = (Father) c.newInstance();
                f.method();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}