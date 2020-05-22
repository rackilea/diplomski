public Map<String, Object> toMap( Object object ) throws Exception
{
    Map<String, Object> map = new LinkedHashMap<>();
    for ( Field field : object.getClass().getDeclaredFields() )
    {
        field.setAccessible( true );
        map.put( field.getName(), field.get( object ) );
    }
    return map;
}