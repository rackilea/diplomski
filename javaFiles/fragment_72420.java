@DataProvider(name = "GoogleDataprovider")
    public Object[][] googleDataprovider() throws IOException {
         Object[][] arrayObject = expectedTitles("Google");
         return arrayObject;
    }


    @DataProvider(name = "MicrosoftDataprovider")
    public Object[][] microsoftDataprovider() throws IOException {
         Object[][] arrayObject = expectedTitles("Microsoft");
         return arrayObject;
    }

    @DataProvider(name = "WallmartDataprovider")
    public Object[][] wallmartDataprovider() throws IOException {
         Object[][] arrayObject = expectedTitles("Wallmart");
         return arrayObject;
    }