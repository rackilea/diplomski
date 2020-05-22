import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DataObject")
public class StringMatchDataObject extends DataObject {

  private String match;

  @Override
  public String getMatch() {
    return match;
  }

  @Override
  public void setMatch(String match) {
    this.match = match; 
  }

}