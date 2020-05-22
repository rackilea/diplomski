public static void showInterfaces(Object obj) {
    showInterfaces(obj.getClass());
}

public static void showInterfaces(Class<?> clazz) {
    for (Class<?> iface : clazz.getInterfaces()) {
        System.out.println(iface.getName());
        showInterfaces(iface);
    }
}