class EnumMap
{
    HashMap<MyEnum, String> map = new HashMap<MyEnum, String>();

    public String getValue(MyEnum e)
    {
        return map.get(e);
    }    
    ..constructor, generics, getters, setters left out.
}