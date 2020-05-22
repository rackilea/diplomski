class Printer {

    private static final Map<Class<?>, BiConsumer<Printer, ?>> map = new HashMap<>();
    private static final BiConsumer<Printer, B> defaultConsumer = (p, b) -> System.out.println("it is b");

    static {
        for(Method m : Printer.class.getDeclaredMethods()) {
            if(m.getName().equals("printIt")) {
                Class<?>[] params = m.getParameterTypes();

                if(params.length == 1 && !params[0].equals(B.class)) {
                    map.put(params[0], (p, b) -> {
                        try {
                            m.invoke(p, b);
                        } catch (Exception e) {
                            // Should never happens
                            throw new RuntimeException("Invalid method mapping");
                        }
                    });
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public <T> void printIt(B b) {
        ((BiConsumer<Printer, T>) map.getOrDefault(b.getClass(), defaultConsumer)).accept(this, (T) b);
    }

    public void printIt(E e) {
        System.out.println("it is e");
    }

}