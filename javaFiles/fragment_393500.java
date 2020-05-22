class SkillConverter implements Converter<Map<String, Object>, List<String>> {

    @SuppressWarnings("unchecked")
    public List<String> convert(Map<String, Object> value) {
        Object values = value.get("values");
        if (values == null || !(values instanceof List)) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<String>();
        for (Object item : (List<Object>) values) {
            Map<String, Object> mapItem = (Map<String, Object>) item;
            Map<String, Object> skillMap = (Map<String, Object>) mapItem.get("skill");
            if (skillMap == null) {
                continue;
            }

            result.add(skillMap.get("name").toString());
        }

        return result;
    }

    public JavaType getInputType(TypeFactory typeFactory) {
        return typeFactory.constructMapLikeType(Map.class, String.class, Object.class);
    }

    public JavaType getOutputType(TypeFactory typeFactory) {
        return typeFactory.constructCollectionLikeType(List.class, String.class);
    }
}