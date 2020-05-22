@Test
public void test(){
    List<InputObject> inputs = new LinkedList<>();
    inputs.add(new InputObject(1,"A","X"));
    inputs.add(new InputObject(1,"B","X"));
    inputs.add(new InputObject(1,"C","X"));
    inputs.add(new InputObject(1,"D","X"));

    inputs.add(new InputObject(2,"A","Y"));
    inputs.add(new InputObject(2,"B","Y"));
    inputs.add(new InputObject(2,"C","Y"));
    inputs.add(new InputObject(2,"D","Y"));

    Map<Integer, Map<String, String>> resultingMap = inputs.stream().collect(Collectors.groupingBy(InputObject::getSet, Collectors.toMap(InputObject::getQuestion, InputObject::getAnswer)));
    List<Assessment> result = resultingMap.entrySet().stream().map(entry -> new Assessment(entry.getKey(), entry.getValue())).collect(Collectors.toList());

    Map<String,String> expectedSet1Data = new LinkedHashMap<>();
    expectedSet1Data.put("A","X");
    expectedSet1Data.put("B","X");
    expectedSet1Data.put("C","X");
    expectedSet1Data.put("D","X");

    Map<String,String> expectedSet2Data = new LinkedHashMap<>();
    expectedSet2Data.put("A","Y");
    expectedSet2Data.put("B","Y");
    expectedSet2Data.put("C","Y");
    expectedSet2Data.put("D","Y");

    assertEquals(new Assessment(1,expectedSet1Data),result.get(0));
    assertEquals(new Assessment(2,expectedSet2Data),result.get(1));
}

@AllArgsConstructor
@Getter
private class InputObject{
    private int set;
    private String question;
    private String answer;
}

@Getter
@AllArgsConstructor
@Data
class Assessment{
    Integer setId;
    Map<String,String> questiontoanswer;
}