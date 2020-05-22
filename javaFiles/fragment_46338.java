private static final Map<String, Supplier<Command>> commandMap = new HashMap<>();

static {
    commandMap.put("Erosion", Erosion::new);
    commandMap.put("Dilation", Dilation::new);
}