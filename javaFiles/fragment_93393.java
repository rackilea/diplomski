@XmlRootElement(name="organisation")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExternalOrganisation {

   private String             name;
   private ExternalFacilities facilities;
   private ExternalLocations  locations;

   ...

}