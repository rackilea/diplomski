class EndianIntAdapter extends XmlAdapter<String, Integer> {
  @Override
  public String marshal(Integer field) throws Exception {
    //int to string based on endianness
  }

  @Override
  public Integer unmarshal(String str) throws Exception {
    //String from xml to int based on endianness
  }
}