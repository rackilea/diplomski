public class Message {

  private static HashMap tagMap;

  static {
     tagMap = new HashMap();
     tagMap.put( 1, "tag1Name");
     tagMap.put( 2, "tag2Name");
     tagMap.put( 3, "tag3Name");
  }

  public Message() {

  }

  public String getTagName( int tagNumber) {
    return tagMap.get( tagNumber);
  }
}