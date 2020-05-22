static final Map<Class<?>, Function<String, Object>> FUNCTION_MAP = new HashMap<>();

static {
    FUNCTION_MAP.put(String.class, s -> s);
    FUNCTION_MAP.put(Float.class, s -> Float.parseFloat(s));
    FUNCTION_MAP.put(Double.class, s -> methodToParseDouble(s));
}