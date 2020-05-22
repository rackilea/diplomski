private static final int TO_LOAD = 1000;
private static final List<Object> _active = new ArrayList<Object>(TO_LOAD);

public static void doNotCollect(Object o)
{
    _active.add(o);
}

System.out.println("Loaded scripts: " + _active.size());