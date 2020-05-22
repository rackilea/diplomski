import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonValue;

@XmlRootElement(name = "data")
public class ListWrapper<T> {
  private List<T> list;

  public ListWrapper() {}

  public ListWrapper(List<T> list) {
    this.list = list;
  }

  /**
   * @return the list
   */
  @XmlAnyElement(lax = true)
  @JsonValue
  public List<T> getList() {
    return list;
  }

  /**
   * @param list
   *               the list to set
   */
  public void setList(List<T> list) {
    this.list = list;
  }
}