Class<?> clazz = ...;
Class<? extends SomeInterface> someInterfaceClass;
try {
    someInterfaceClass = clazz.asSubclass(SomeInterface.class);
}
catch (ClassCastException cce) {
    throw new IllegalStateException("Specified type doesn't implement SomeInterface", cce);
}
SomeInterface[] enumConstants = someInterfaceClass.getEnumConstants();
if (enumConstants == null) {
    throw new IllegalStateException("Specified type is not an enum.");
}

//use constants