public static void main(String[] args) throws Exception {
    Constructor<SecondaryType> constructor = SecondaryType.class.getDeclaredConstructor();
    constructor.setAccessible(true); // if not set accessible, you will get an exception
    SecondaryType instance = constructor.newInstance();
    System.out.println(instance);
}