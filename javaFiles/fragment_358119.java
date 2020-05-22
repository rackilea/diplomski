Method interfaceMethod = ...; // method whose implementation you're looking for
try {
    Method implementationMethod = concreteClass.getMethod(
        interfaceMethod.getName(), interfaceMethod.getParameterTypes());
} catch (NoSuchMethodException E) {
    // your class may be abstract and thus would not implement given method
} catch (SecurityException E) {
    // insufficient permissions
}