public static void main( final String[] args) {

    Main main = new Main();
    main.setApplicationContextUri("classpath:META-INF/applicationContext.xml");
    main.enableHangupSupport();

    try {
        main.run();
    } ...
}