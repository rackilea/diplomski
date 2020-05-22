public void discardMap() {
    //CustomMap map = (CustomMap) hi.getMap();
    //map.discard();
    try {
        Object o =hi.getClass().getMethod("getMap").invoke(hi);
        Method m = o.getClass().getMethod("discard");
        m.setAccessible(true);
        m.invoke(o);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}