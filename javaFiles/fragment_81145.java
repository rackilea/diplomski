@XmlRootElement(name="Data")
class Data
{
   @XmlJavaTypeAdapter(MapAdapter.class)
   @XmlElements({
       @XmlElement(name="Protocol1",type=Protocol1.class),
       @XmlElement(name="Protocol2",type=Protocol2.class),
       ....
   })
   Map<String,Protocol> protocolMap;
}