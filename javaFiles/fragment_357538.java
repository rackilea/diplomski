public class NodeValueStringAttrMarshaller extends XmlAdapter<NodeValueElement, String> {

    @Override
    public NodeValueElement marshal(String v) throws Exception {
        return new NodeValueElement(v);
    }

    @Override
    public String unmarshal(NodeValueElement v) throws Exception {
        if (v==null) return "";
        return v.getValue();
    }

}