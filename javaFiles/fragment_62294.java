public static String[] toSimpleNames(Class... classes){
    String[] names = new String[classes.length];

    for (int i = 0; i < classes.length; i++) {
        names[i] = classes[i].getSimpleName();
    }

    return names;
}