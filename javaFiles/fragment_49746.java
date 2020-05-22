Class<?>[] classes = { A.class, B.class };
for(Class<?> c: classes) {
    System.out.println(c);
    for(Method m: c.getDeclaredMethods()) {
        for(Annotation a: m.getDeclaredAnnotations())
            System.out.print(a+" ");
        System.out.println(m);
    }
    System.out.println();
}