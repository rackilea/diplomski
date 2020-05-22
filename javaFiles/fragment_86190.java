public void printInterface(Class<?> clazz) {
    System.err.println("public interface I" + clazz.getSimpleName() + "{");
    for (Method m : clazz.getDeclaredMethods()) {
        String params = "";
        for (Parameter p : m.getParameters()) {
            if (params != "")
                params += ", ";
            params += p.getType().getSimpleName() + " value";
        }
        System.err.println("  " + m.getReturnType().getSimpleName() + " " + m.getName() + "(" + params + ");");
    }
    for (Class<?> c : clazz.getDeclaredClasses()) {
        printInterface(c);
    }
    System.err.println("}");
}