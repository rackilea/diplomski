public static void main(String[] args) {
        System.setProperty("timestamp",String.valueOf(System.currentTimeMillis()));

        new SpringApplicationBuilder() //
                .sources(Launcher.class)//
                .run(args);
    }