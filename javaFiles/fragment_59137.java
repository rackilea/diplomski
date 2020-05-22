class MyObject {
    private static List instances = new ArrayList();

    public static MyObject createMyObject() {
    MyObject o = new MyObject();
    instances.add(new java.lang.ref.WeakReference(o));
    return o;
    }

    public static List getInstances() {
    return instances;
    }

    private MyObject() {
    // Not allowed 
    }
  }