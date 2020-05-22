@DataProvider(name ="abc")
public static Object[][] getData() {
    //code to read excel file goes here
    HashMap<String, String> data = new HashMap();

    data.put("Column1","data1");
    data.put("Column2","data2");
    data.put("Column3","data3");
    return new Object[] {data};
}

@Test(dataProvider="abc", dataProviderClass=TestClass.class)
public void test(HashMap<String, String> data) {
    //use data here
}