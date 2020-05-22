@JsonCreator
    public static DisplayMode forValue(String v) {
        return Arrays.stream(DisplayMode.values())
                .filter(dm -> dm.name().equalsIgnoreCase(v))
                .findAny().orElse(null);
    }