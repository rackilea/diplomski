public class Settings {
  private int offset;
  private int limit;
  private String type;
  private Map<String, Criteria> criteria;
  private Criteria criteria;
}


 class Criteria {
    private String restriction;
    private Object value;
  }