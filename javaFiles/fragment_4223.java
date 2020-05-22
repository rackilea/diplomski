@Test
        public void DemoTest() throws Exception {
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Not Meta";
        String actualTitle = "";
        driver.get(baseUrl);
        actualTitle = driver.getTitle();
        assertEquals(actualTitle , expectedTitle );