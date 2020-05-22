static class Service {
    void testMethod() {
        Map<String, Object> aMap = new HashMap<String, Object>();
        aMap.put("someKey", "someValue");

        NotificationsUtils.generateXML("test", aMap);
    }
}

static class NotificationsUtils {
    static void generateXML(String s, Map<String, Object> map) {}
}

@Tested Service testService;

@Test
public void test(@Mocked NotificationsUtils utils) {
    Deencapsulation.invoke(testService, "testMethod");

    new Verifications() {{
        Map<String, Object> map;
        NotificationsUtils.generateXML(anyString, map = withCapture());
        assertEquals("someValue", map.get("someKey"));
    }};
}