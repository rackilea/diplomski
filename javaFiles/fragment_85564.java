public void testDisplayBlackBox() {
    //Enter any integer/decimal value for first editfield, we are writing 10
    solo.enterText(0, "10");
    //Enter any interger/decimal value for first editfield, we are writing 20
    solo.enterText(1, "20");
    //Click on Multiply button
    solo.clickOnButton("Multiply");
    //Verify that resultant of 10 x 20
    assertTrue(solo.searchText("200"));
    ArrayList <View> aview= solo.getCurrentViews();
    StringBuilder sB = new StringBuilder();
    for (View v:aview)
    {           
        sB.append(v.toString());
    }
    saveToFile(sB.toString())
}


public void saveToFile(String text) {
    try {
        String path = Environment.getExternalStorageDirectory();
        File file = new File(path, test.txt);
        FileOutputStream fos = new FileOutputStream(file);
        byte[] data = text.getBytes();
        fos.write(data);
        fos.flush();
        fos.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}