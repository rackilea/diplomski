public static List<LinkedHashMap> addresstoMap(List<Address> addresses)
{
    List<LinkedHashMap> list = new ArrayList<>();
    for(Address a: addresses){
        LinkedHashMap map = new LinkedHashMap();
        // Add address fields to map here
        list.add(map);
    }
    return list;
}