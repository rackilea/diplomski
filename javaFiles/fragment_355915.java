public static <T> Set<? extends T> getClassesExtending(Class<T> clazz) {
        Reflections reflections = new Reflections("");
        Set<Class<? extends T>> classes = reflections.getSubTypesOf(clazz);

        if (classes.size() <= 0) return new HashSet<>();

        Set<? extends T> extending =
                classes.stream().map(aClass -> {
                    try {
                        return aClass.getConstructor().newInstance();
                    } catch (Exception e) {
                        return null;
                    }
                }).collect(Collectors.toSet());
         return extending;
    }