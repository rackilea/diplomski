public class TestParameterDataProvider {

    @Test(dataProvider = "provideFilenames")
    public void test(String filename) {
        //openFile(filename)
        //assert stuff...
    }

    @DataProvider(name = "provideFilenames")
    public String[] provideData() {
        return new String[] { 
            "filename1", "filename2", "filename3" 
        };
    }

}