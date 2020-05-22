@Test
public void assertMap() throws Exception {
  Map<String, String> expectedMap = new HashMap<String, String>();
  expectedMap.put("a", "1");
  expectedMap.put("b", "2");

  Map<String, String> actualMap = new HashMap<String, String>();
  actualMap.put("b", "2");
  actualMap.put("a", "1");

  ReflectionAssert.assertReflectionEquals(expectedMap, actualMap, ReflectionComparatorMode.LENIENT_ORDER);

}