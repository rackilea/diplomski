public static void main( String [ ] args )
{
    TestMap<String, Integer> testHashMap = new TestMap<String,Integer>(new HashMap<String, Integer>());
    testHashMap.internalMap.put("Pittsburgh Steelers", 6);

    TestMap<String, Integer> testTreeMap = new TestMap<String,Integer>(new TreeMap<String, Integer>());
    testTreeMap.internalMap.put("Pittsburgh Steelers", 6);
}