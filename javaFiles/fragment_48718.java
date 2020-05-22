@Data
 @XmlRootElement(name = "TYPES")
 @XmlAccessorType(XmlAccessType.FIELD)
 class SomeModel {

    @XmlElement(name = "TYPE")
    private SomeOtherModel[] type;

 }