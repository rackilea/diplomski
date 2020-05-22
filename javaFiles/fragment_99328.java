public static void test(int some, String... args) {
        System.out.print("\n" + some);
        for(String arg: args) {
            System.out.print(", " + arg);
        }
    }