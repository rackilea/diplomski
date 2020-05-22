private static Undertow server;

    @BeforeAll
    public static void startServer() throws ServletException {
        server = ServletUtils.buildUndertowServer(
                8080,
                "localhost",
                "",
                SpringServletContainerInitializer.class,
                Collections.singleton(
                        MySpringServletInitializer.class),
                MyTests.class.getClassLoader());
        server.start();
    }

    @AfterAll
    public static void stopServer() {
        try {
            if (server != null) {
                server.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIsAvailable() {
        Response response = get("/mystuff/isAvailable");
        response.then().statusCode(200);
        ResponseBody body = response.getBody();
        assertThat("Body", body.asString(), is(equalTo("ok")));
    }