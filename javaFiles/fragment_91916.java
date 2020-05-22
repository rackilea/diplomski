31    protected TypeReference()
32    {
33        Type superClass = getClass().getGenericSuperclass();
34        if (superClass instanceof Class<?>) { // sanity check, should never happen
35            throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
36        }
45    }