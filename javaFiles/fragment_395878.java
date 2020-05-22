@Test
public void test() throws Exception {
    WebDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);
    WebClient webClient = (WebClient) get(driver, "webClient");
    System.out.println(webClient.getBrowserVersion());
    System.out.println(webClient.getBrowserVersion().isIE());
    driver.close();
}

private static Object get(Object object, String field) throws Exception {
    Field f = object.getClass().getDeclaredField(field);
    f.setAccessible(true);
    return f.get(object);
}