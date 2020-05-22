public class SampleDigester
{
  private Map<String, String> map = new HashMap<String, String>();

  public void run() throws IOException, SAXException {    
    Digester digester = new Digester();
    digester.push(this);

    digester.addCallMethod("ShowPercentage/SPGLevel", "addKey", 2);
    digester.addCallParam("ShowPercentage/SPGLevel/Level", 0);
    digester.addCallParam("ShowPercentage/SPGLevel/percentage", 1);
    digester.parse("input.xml");

  }

  public void addKey(String key, String value) {
    map.put(key, value);
  }

}