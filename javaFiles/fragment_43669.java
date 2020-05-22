static class HackedObjectInputStream extends ObjectInputStream
{

    /**
     * Migration table. Holds old to new classes representation.
     */
    private static final Map<String, Class<?>> MIGRATION_MAP = new HashMap<String, Class<?>>();

    static
    {
        MIGRATION_MAP.put("DBOBHandler", com.foo.valueobjects.BoardHandler.class);
        MIGRATION_MAP.put("DBEndHandler", com.foo.valueobjects.EndHandler.class);
        MIGRATION_MAP.put("DBStartHandler", com.foo.valueobjects.StartHandler.class);
    }

    /**
     * Constructor.
     * @param stream input stream
     * @throws IOException if io error
     */
    public HackedObjectInputStream(final InputStream stream) throws IOException
    {
        super(stream);
    }

    @Override
    protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException
    {
        ObjectStreamClass resultClassDescriptor = super.readClassDescriptor();

        for (final String oldName : MIGRATION_MAP.keySet())
        {
            if (resultClassDescriptor.getName().equals(oldName))
            {
                String replacement = MIGRATION_MAP.get(oldName).getName();

                try
                {
                    Field f = resultClassDescriptor.getClass().getDeclaredField("name");
                    f.setAccessible(true);
                    f.set(resultClassDescriptor, replacement);
                }
                catch (Exception e)
                {
                    LOGGER.severe("Error while replacing class name." + e.getMessage());
                }

            }
        }

        return resultClassDescriptor;
    }