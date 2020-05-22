public static void main(String[] args) throws Exception {   //Read user input into the array
    Method method = Main.class.getDeclaredMethod("main", String[].class);
    int modifiers = method.getModifiers();
    System.out.println(modifiers);

    System.out.println(Modifier.isStatic(modifiers));
    System.out.println(Modifier.isPublic(modifiers));
    System.out.println(Modifier.isAbstract(modifiers));
}