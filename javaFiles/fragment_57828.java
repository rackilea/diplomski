@XStreamAlias("Objects")
public class ParentResponseObject {

    @XStreamImplicit
    private final List <ResponseObject> responseObjects = new ArrayList<ResponseObject>();

    public ParentResponseObject() {
    }

    public List<ResponseObject> getResponseObjects() {
        return responseObjects;
    }
}