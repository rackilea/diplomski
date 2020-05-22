@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Phone", propOrder = {
"description"
 }
@XmlRootElement(name="phone")
public class Phone
          extends PhoneBase
{

@XmlElementWrapper(name = "descriptions")
@JsonProperty(value = "descriptions")
@XmlElement(required = true)
protected List<Description> description;

public List<Description> getDescription() {
if (description == null) {
    description = new ArrayList<Description>();
}
return this.description;
}
}