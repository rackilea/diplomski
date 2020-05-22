protected Map<String, Alarmdiensten> getAlarmdiensten()
{
  Map<String, Alarmdiensten> alarmNumbersForCountries 
                                             = new HashMap<String, Alarmdiensten>();

  try
  {
    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document doc = builder.parse(getAssets().open("alarmdiensten.xml"));
    NodeList nl = doc.getElementsByTagName("land");
    for (int i = 0; i < nl.getLength(); i++)
    {
      Node node = nl.item(i);
      Alarmdiensten land = new Alarmdiensten();

      land.setLand(Xml.innerHtml(Xml.getChildByTagName(node, "naam")));
      land.setLandcode(Xml.innerHtml(Xml.getChildByTagName(node, "code")));
      land.setPolitie(Xml.innerHtml(Xml.getChildByTagName(node, "politie")));
      land.setAmbulance(Xml.innerHtml(Xml.getChildByTagName(node, "ambulance")));
      land.setBrandweer(Xml.innerHtml(Xml.getChildByTagName(node, "brandweer")));
      land.setTelamba(Xml.innerHtml(Xml.getChildByTagName(node, "telamba")));
      land.setAdresamba(Xml.innerHtml(Xml.getChildByTagName(node, "adresamba")));

      alarmNumbersForCountries.put(land.getLandCode(), land);
    }
  } 
  catch (Exception e)
  {
    // Handle Exception
  } 
  return alarmNumbersForCountries;
}