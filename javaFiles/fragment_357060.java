@JsonInclude(Include.NON_DEFAULT)
public class Bean {
  private int val;
  public int getVal() { return val; }
  public void setVal(int val) { this.val = val; }
}

Bean b = new Bean();
b.setVal(0);
new ObjectMapper().writeValueAsString(b); // "{}"