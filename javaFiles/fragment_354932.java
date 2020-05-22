private long computeSize(InstanceKlass k) {
  long size = 0L;

  // the InstanceKlass object itself
  size += k.getObjectSize();

  // Constant pool
  ConstantPool cp = k.getConstants();
  size += cp.getObjectSize();
  size += objectSize(cp.getCache());
  size += objectSize(cp.getTags());

  // Interfaces
  size += arraySize(k.getLocalInterfaces());
  size += arraySize(k.getTransitiveInterfaces());

  // Inner classes
  size += objectSize(k.getInnerClasses());

  // Fields
  size += objectSize(k.getFields());

  // Methods
  ObjArray methods = k.getMethods();
  int nmethods = (int) methods.getLength();
  if (nmethods != 0L) {
     size += methods.getObjectSize();
     for (int i = 0; i < nmethods; ++i) {
        Method m = (Method) methods.getObjAt(i);
        size += m.getObjectSize();
        size += objectSize(m.getConstMethod());
     }
  }

  // MethodOrdering - an int array that records the original
  // ordering of methods in the class file
  size += arraySize(k.getMethodOrdering());

  return size;
}