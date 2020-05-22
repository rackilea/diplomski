ThreadLocal<String> threadLocal= new ThreadLocal<>();

        IntStream.range(0, 8).parallel().forEach(n -> {
            threadLocal.set("MAIN");
            System.out.println("This is sequence access "+n);
            System.out.printf("Service used ThreadLocal - %d: %s\n", n, threadLocal.get());
        });