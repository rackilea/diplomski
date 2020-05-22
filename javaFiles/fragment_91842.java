static <T extends Enum<T>> Enum<T> getValue(String className, String name)
        throws ClassNotFoundException {
    @SuppressWarnings("unchecked")
    Class<T> clazz = (Class<T>) Class.forName(className);
    return Enum.valueOf(clazz, name);
}

public static void main(String[] args) throws Exception {
    String className = "Day";
    String name = "SATURDAY";
    // Note use of raw type       
    System.out.println("Parsed: " + getValue(className, name));
}