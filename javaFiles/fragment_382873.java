@Override
public Map<String, ExecutionContext> partition(int gridSize) {
    Map<String, ExecutionContext> partitionMap = new HashMap<String, ExecutionContext>();
    List<String> codes = getCodes();

    for (String code : codes)
    {
        ExecutionContext context = new ExecutionContext();
        context.put("keyString", code);
        partitionMap.put(code, context);
    }
    return partitionMap;
}