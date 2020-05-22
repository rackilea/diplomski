public void test() {
    Map<String, Object> data = new HashMap<>();
    data.put("key", "value");
    assertThat(data.get("key"), is("value"));

    Map<String, Object> expectedData = Collections.singletonMap("key", "value");
    assertThat(data, is(expectedData));
}