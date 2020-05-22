@XmlRootElement(name="Data")
class Data
{
   @XmlJavaTypeAdapter(MapAdapter.class)
   @XmlPath(".")
   Map<String,Protocol> protocolMap;
}