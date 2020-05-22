@Test
public void getUrl(){
    System.setProperty("property.name", "https://justatest.com/dav/bulk");
    String fileUrl = csvConfig.getFileUrl();
    assertEquals(fileUrl, "https://justatest.com/dav/bulk/otherstuff");
}