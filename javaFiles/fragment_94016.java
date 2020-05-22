class MapMyHolderConverter implements Converter<Map<String, List<Map<String, Object>>>, List<MyHolder>> {

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return typeFactory.constructMapType(Map.class, String.class, List.class);
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return typeFactory.constructCollectionType(List.class, MyHolder.class);
    }

    @Override
    public List<MyHolder> convert(Map<String, List<Map<String, Object>>> map) {
        Collection<List<Map<String, Object>>> values = map.values();
        if (values.isEmpty()) {
            return Collections.emptyList();
        }

        List<MyHolder> result = new ArrayList<>();
        for (Map<String, Object> item : values.iterator().next()) {
            MyHolder holder = new MyHolder();
            holder.setName(item.get("1").toString());
            holder.setAge(item.get("2").toString());
            holder.setFemale((Boolean) item.get("3"));
            result.add(holder);
        }

        return result;
    }
}