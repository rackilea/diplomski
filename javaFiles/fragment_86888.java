public class MyStuffToList implements TypeHandler<List<GetMyStuffResult>> {

    // Other Overrides Here

    @Override
    public List<GetMyStuffResult> getResult(CallableStatement cs, int columnIndex) 
    throws SQLException {
        List<GetMyStuffResult> results = new ArrayList<GetMyStuffResult>();
        Array array = cs.getArray(columnIndex);

        // Add a TypeMap to map the Oracle object to a Java class
        Map<String, Class<?>> typeMap = new HashMap<String, Class<?>>();
        typeMap.put("MySchema.MY_TYPE", GetMyStuffResult.class);

        // Get an array of Java objects using that type map
        Object[] javaObjects = (Object[]) array.getArray(typeMap);

        // add each of these converted objects to the results list
        for (Object javaObject : javaObjects) {
            results.add((GetMyStuffResult) javaObject);
        }

        return results;
    }
}