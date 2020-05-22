private static final Map primitiveTypeNameMap = new HashMap(16);
// and populate like this
primitiveTypeNames.addAll(Arrays.asList(new Class[] {
        boolean[].class, byte[].class, char[].class, double[].class,
        float[].class, int[].class, long[].class, short[].class}));
for (Iterator it = primitiveTypeNames.iterator(); it.hasNext();) {
    Class primitiveClass = (Class) it.next();
    primitiveTypeNameMap.put(primitiveClass.getName(), primitiveClass);
}