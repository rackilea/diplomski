public enum ListType { LIST1, LIST2,..... };
...
EnumMap<ListType, List<DictionaryELement>> lists = new EnumMap<>(ListType.class);
...

for (ListType t : ListType.values())
{
    lists.put(t,new ArrayList<DictionaryELement>());
}