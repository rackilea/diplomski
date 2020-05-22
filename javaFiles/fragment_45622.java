import java.lang.annotation.Annotation;

public class TestData implements Tcms {

  private String tcmsId;
  private String data;

  public TestData(String tcmsId, String data) {
    this.tcmsId = tcmsId;
    this.data = data;
  }

  @Override
  public String id() {
    return tcmsId;
  }

  public String getData() {
    return data;
  }

  @Override
  public Class<? extends Annotation> annotationType() {
    return Tcms.class;
  }

  @Override
  public String toString() {
    return getData();
  }
}