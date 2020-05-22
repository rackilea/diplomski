class Utils {
    public static List<Field> getStringFields(Class<?> clazz) { ... }

    public static void capitaliseEverythingInADodgyNonOOPWay(Object changeMe) {
        for(Field field : getStringFields(changeMe.getClass())) {
            // Add try catch etc...
            field.setAccessible(true);
            field.set(changeMe, field.get(changeMe).toString().toUpperCase());
        }
    }
}