public static class ProxyObject extends ObjectToProxy
{
    private final ObjectToProxy objectToProxy;

    public ProxyObject(ObjectToProxy objectToProxy)
    {
        this.objectToProxy = objectToProxy;
    }

    @Override
    public String toString()
    {
        return "ProxyObject";
    }
}

public static class ObjectToProxy
{
    List<ObjectToProxy> potentiallyCircularReference;

    public ObjectToProxy()
    {
        potentiallyCircularReference = new ArrayList<>();
        potentiallyCircularReference.add(this);
    }

    @Override
    public String toString()
    {
        return "ObjectToProxy";
    }
}

public static class SubClass
{
    ObjectToProxy aField;
    Set<ObjectToProxy> aSetOfObjectsToProxy;
}

public static class CrazyObject
{
    Map<Integer, ObjectToProxy> proxiedObjects;
    List<SubClass> manySubClasses;

    public CrazyObject()
    {
        proxiedObjects = new HashMap<>();
        proxiedObjects.put(1, new ObjectToProxy());
    }
}

public static class ComplexObject
{
    List<CrazyObject> crazyObjects;
    final ObjectToProxy storedAsAField;

    public ComplexObject()
    {
        this.storedAsAField = new ObjectToProxy();
        crazyObjects = new ArrayList<>();
        crazyObjects.add(new CrazyObject());
    }

    @Override
    public String toString()
    {
        return "myField: " + storedAsAField.toString();
    }
}

public static void main(String[] args) throws Exception
{   
    ComplexObject obj = new ComplexObject();
    Set<Object> visitedObjects = Sets.newIdentityHashSet();
    Queue<Object> objectsToVisit = new LinkedList<>();
    visitedObjects.add(obj);
    objectsToVisit.add(obj);
    while (!objectsToVisit.isEmpty())
    {
        handleFields(objectsToVisit.poll(), visitedObjects, objectsToVisit);
    }
    System.out.println(obj.toString());
}

private static void handleFields(Object obj, Set<Object> visitedObjects, Queue<Object> objectsToVisit) throws Exception
{
    List<Field> fields = getAllFields(obj);
    for (Field field : fields)
    {
        field.setAccessible(true);
        Object fieldValue = field.get(obj);
        if (fieldValue != null && !visitedObjects.contains(fieldValue))
        {
            if (fieldValue instanceof Object[])
            {
                visitedObjects.add(fieldValue);
                Object[] array = (Object[])fieldValue;
                for (Object arrayObj : array)
                {
                    if (arrayObj != null && !objectsToVisit.contains(arrayObj))
                    {
                        visitedObjects.add(arrayObj);
                        if (!DontLookAt.contains(arrayObj.getClass()))
                            objectsToVisit.add(arrayObj);
                    }
                }
            }
            else
            {
                if (!DontLookAt.contains(fieldValue.getClass()))
                    objectsToVisit.add(fieldValue);
            }
            if (fieldValue.getClass().equals(ObjectToProxy.class))
            {
                field.set(obj, new ProxyObject((ObjectToProxy)fieldValue));
            }
            else if (fieldValue instanceof ObjectToProxy[])
            {
                ObjectToProxy[] array = (ObjectToProxy[])fieldValue;
                for (int i = 0; i < array.length; i++)
                {
                    if (array[i] != null)
                        array[i] = new ProxyObject(array[i]);
                }
            }
        }
    }
}

private static final Set<Class> DontLookAt = getDontLookAtSet();

private static Set<Class> getDontLookAtSet()
{
    Set<Class> set = new HashSet<>();
    set.add(Long.class);
    set.add(Boolean.class);
    set.add(Integer.class);
    set.add(String.class);
    set.add(Byte.class);
    set.add(Double.class);
    set.add(Float.class);
    set.add(Class.class);
    return set;
}

private static List<Field> getAllFields(Object obj) throws Exception
{
    List<Field> output = new ArrayList<>();
    Class klazz = obj.getClass();
    while (!klazz.equals(Object.class))
    {
        Field[] fields = klazz.getDeclaredFields();
        output.addAll(Arrays.asList(fields));
        klazz = klazz.getSuperclass();
    }
    return output;
}