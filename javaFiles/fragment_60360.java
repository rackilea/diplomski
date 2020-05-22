package forum7104810;

import java.util.Set;
import java.util.TreeSet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="root")
class MyParentClass {

  // Initialize this property with an instance of the desired type.
  private Set<MyFieldItem> items = new TreeSet<MyFieldItem>();

  public void setItems(Set<MyFieldItem> items) {
    this.items = items;
  }

  @XmlElementWrapper(name="mylist") 
  @XmlElement(name="item")
  public Set<MyFieldItem> getItems() {
    return items;
  }

}