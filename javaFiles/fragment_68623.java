Class<?> c = obj.getClass();
do {
    for (Method m : c.getDeclaredMethods())
        if (isAMatch(m))
            return m;
} while ((c = c.getSuperclass()) != null);