class ProtectedContextFactory extends ContextFactory
{
    private static final ProtectedWrapFactory wrapper = new ProtectedWrapFactory();

    @Override
    protected Context makeContext()
    {
        Context c = super.makeContext();
        c.setWrapFactory(wrapper);

        return c;
    }
}

class ProtectedWrapFactory extends WrapFactory
{
    @Override
    public Scriptable wrapAsJavaObject(Context cx, Scriptable scope, Object javaObject, Class<?> staticType)
    {
        return new ProtectedNativeJavaObject(scope, javaObject, staticType);
    }
}

class ProtectedNativeJavaObject extends NativeJavaObject
{
    private static final HashMap<Class<?>, ArrayList<String>> CLASS_PROTECTION_CACHE = new HashMap<Class<?>, ArrayList<String>>();

    private ArrayList<String> m_protectedMembers;

    public ProtectedNativeJavaObject(Scriptable scope, Object javaObject, Class<?> staticType)
    {
        super(scope, javaObject, staticType);

        Class<?> clazz = javaObject != null ? javaObject.getClass() : staticType;

        m_protectedMembers = CLASS_PROTECTION_CACHE.get(clazz);

        if(m_protectedMembers == null)
            m_protectedMembers = processClass(clazz);
    }

    private static ArrayList<String> processClass(Class<?> clazz)
    {
        ArrayList<String> protectedMethods = new ArrayList<String>();

        CLASS_PROTECTION_CACHE.put(clazz, protectedMethods);

        for(Method m : clazz.getMethods())
        {
            if(m.getAnnotation(ScriptHiddenMember.class) != null)
                protectedMethods.add(m.getName());
        }

        for(Field f : clazz.getFields())
        {
            if(f.getAnnotation(ScriptHiddenMember.class) != null)
                protectedMethods.add(f.getName());
        }
        return protectedMethods;
    }

    @Override
    public boolean has(String name, Scriptable start)
    {
        if(m_protectedMembers.contains(name))
            return false;
        else
            return super.has(name, start);
    }

    @Override
    public Object get(String name, Scriptable start)
    {
        if(m_protectedMembers.contains(name))
            return NOT_FOUND;
        else
            return super.get(name, start);
    }
}

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ScriptHiddenMember {}