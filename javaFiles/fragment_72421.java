@Test(dataProvider="GoogleDataprovider")
    public void testGoogleData(String title, String url, String domain) {
        Assert.assertEquals("Google", title);
        Assert.assertEquals("www.google.com", url);
        Assert.assertEquals("Search engine", domain);
    }

    @Test(dataProvider="MicrosoftDataprovider")
    public void testMicrosoftData(String title, String url, String domain) {
        Assert.assertEquals("Microsoft", title);
        Assert.assertEquals("www.microsoft.com", url);
        Assert.assertEquals("Operating System", domain);
    }


    @Test(dataProvider="WallmartDataprovider")
    public void testWallmartData(String title, String url, String domain) {
        Assert.assertEquals("Wallmart", title);
        Assert.assertEquals("www.wallmart.com", url);
        Assert.assertEquals("Retail", domain);

    }