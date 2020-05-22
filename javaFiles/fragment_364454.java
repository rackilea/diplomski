public static <T extends Enum<T> & Unit> Class<T> getEnumClass(String unitValueClassName) {
    unitValueClassName = normalizeEnumClassName(unitValueClassName);

    Class<?> clazz;
    if (unitValueClassName.equals(DENSITY_CLS)) {
        clazz = DensityUnit.class;
    } else if (unitValueClassName.equals(LENGTH_CLS)) {
        clazz = LengthUnit.class;
    } else if (unitValueClassName.equals(LENGTH_OPTIONAL_CLS)) {
        clazz = LengthUnit.class;
    } else if (unitValueClassName.equals(VOLUME_CLS)) {
        clazz = VolumeUnit.class;
    } else if (unitValueClassName.equals(WEIGHT_CLS)) {
        clazz = WeightUnit.class;
    } else if (unitValueClassName.equals(TIME_CLS)) {
        clazz = TimeUnit.class;
    } else {
        throw new IllegalArgumentException("Please add the enum class to UnitValueView.getEnumClass(String) : " + unitValueClassName);
    }
    return (Class<T>) clazz;
}