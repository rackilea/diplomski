class ActivationEffectsFactory {
    private static Map<String, Class<? extends ActivationEffect>> map = new HashMap<>();
    static
    {
        add( "Smack Fools", SmackFools.class );
        add( "Have a Nap", Naptime.class );
    }

    private static void add(String name, Class<? extends ActivationEffect> behaviour) {
        assert !map.containsKey(name);
        assert behaviour!=null && name!=null;
        map.put(name, behaviour);
    }

    public static ActivationEffect build(String name) 
    {
        ActivationEffect res;
        try {
            res = map.get(name).newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            res = null;
        }
        if ( res==null )
            throw new IllegalArgumentException( "Incorrect behaviour name : " + name );
        return res;
    }
}