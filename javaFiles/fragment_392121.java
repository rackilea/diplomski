@XmlRootElement(name = "ProtocolloList")
public class ProtocolloList {

  private ArrayList<Protocollo> ProtocolloList;

  @XmlElement(name = "protocollo")
  public ArrayList<Protocollo> getProtocolloList() {
      return ProtocolloList;
  }

}