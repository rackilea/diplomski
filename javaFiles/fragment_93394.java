@XmlRootElement(name="organisation")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExternalOrganisation {

   private String             name;

   @XmlElementWrapper
   @XmlElementRef
   private List<ExternalFacility> facilities;

   @XmlElementWrapper
   @XmlElementRef
   private List<ExternalLocation>  locations;

   ...

}