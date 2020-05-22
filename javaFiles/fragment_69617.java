@XmlType(name = "root")
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.NONE)
public class Root {

    private ArrayList<Resource> resources = new ArrayList<Resource>();

    public void addResource(Resource resource) {
        resources.add(resource);
    }

    @XmlElementRefs(value = { @XmlElementRef(type = Element.class),
                              @XmlElementRef(type = ListType.class),
                              @XmlElementRef(type = FieldType.class) })
    public List<Object> getResourceFields() {
        List<Object> list = new ArrayList<Object>();
        for (Resource r : resources) {
            list.add(r.getElement());
            list.add(r.getFieldType());
            list.add(r.getListType());
        }
        return list;
    }
}