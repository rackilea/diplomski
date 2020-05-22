@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public static class LeafElementHolder {
    @XmlAnyElement
    private Object leaf;

    public Object getLeaf() {
        return leaf;
    }

    public void setLeaf(Object leaf) {
        this.leaf = leaf;
    }
}