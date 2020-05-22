public class JSONHelperTest {
@Test
public void parseListOnPositionFullListTest() throws JsonProcessingException, IOException {
    String inputWithFullList = "[\"a\",[\"b\", \"c\", \"d\"],[],[]]";
    List<String> result = JSONHelper.getListOnPosition(1, inputWithFullList);
    assertEquals(3, result.size());
    assertEquals(Arrays.asList("b", "c", "d"), result);
}

@Test
public void parseListOnPositionOneElementListTest() throws JsonProcessingException, IOException {
    String inputWithFullList = "[\"a\",[\"b\"],[],[]]";
    List<String> result = JSONHelper.getListOnPosition(1, inputWithFullList);
    assertEquals(1, result.size());
    assertEquals(Arrays.asList("b"), result);
}

@Test
public void parseListOnPositionEmptyListTest()  throws JsonProcessingException, IOException {
    String inputWithFullList = "[\"a\",[],[],[]]";
    assertTrue(JSONHelper.getListOnPosition(1, inputWithFullList).isEmpty());
}
}