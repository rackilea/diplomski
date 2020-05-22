public static void connect(InetAddress paramInetAddress,
            @Super Object parentObj, @This Object myself, @SuperCall Callable<?> call) throws SessionException {
        try {
            System.out.println("hi from hijacked");
            parentObj.getClass().getMethods();
            Field IMPL_LOOKUP = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
            IMPL_LOOKUP.setAccessible(true);
            MethodHandles.Lookup lkp = (MethodHandles.Lookup) IMPL_LOOKUP.get(null);
            MethodHandle h1 = lkp.findSpecial(b.class, "connect", MethodType.methodType(void.class), Session3270.class);
            h1.invoke(myself);
        } catch (Throwable e) {
            throw new RuntimeException(e);

        }
    }