public class SimpleMulticastBean implements DelegatationProvider {
  private String value;
  public String getValue() {
    return value;
  }
  public void setValue(String value) {
    this.value = value;
  }
}

public interface DelegatationProvider {
  void setValue(String value);
}