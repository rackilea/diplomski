public static <T> T getMappedRootObject(T instance, String filename) {
     //.......

    if (instance == null) {
        // handle this
    } else {
        T container = new Gson().fromJson(br, instance.getClass());
        return container;
    }
}