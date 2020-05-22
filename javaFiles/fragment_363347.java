enum SampleFields {
  TWO(/*build a map "name"->"html","find"->"css")*/ ),
  ONE_KEY(/*build a map "java"->"java","jsp"->"jsp", ...*/);

  private Map<String, String> values;

  private SampleFields(Map<String, String> map) { 
    values = map;
  }
}