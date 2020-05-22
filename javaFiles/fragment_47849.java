// This is okay because we're switching to a type with an unbounded wildcard -
// the behaviors of Class.newInstance and Class.cast are still safe.
@SuppressWarnings("unchecked") 
Class<MyClass<?>> classWithNarrowedType =
        (Class<MyClass<?>>)(Class<?>)MyClass.class;
populateMap(m, classWithNarrowedType);