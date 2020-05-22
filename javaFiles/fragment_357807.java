public class SingletonMapPrimarySecondary {
    Map<Class, String> mapPrimary;
    Map<Class, String> mapSecondary;

    // TODO: Handle mapPrimary and mapSecondary creation and singleton pattern

    public String getPrimary(Class clazz) {
        String primary = mapPrimary.get(clazz);
        if (primary == null) {
            primary = getFieldNameUsingReflection(clazz, Primary.class);
            mapPrimary.put(clazz, primary);
        }
        return primary;
    }

    public String getSecondary(Class clazz) {
        // TODO: Similar to getPrimary
    }
}