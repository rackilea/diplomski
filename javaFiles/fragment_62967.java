@XmlAccessorType(PROPERTY)
public class A {
    private List<XXX> children;

    @XmlElements( { //
    @XmlElement(name = "g", type = A.class),
        @XmlElement(name = "x", type = X.class), 
        @XmlElement(name = "y", type = Y.class),        
    })
    public List<XXX> getChildren() {
       return children;
    }

    public void setChildren(List<XXX> children) {
       this.children = children;
    }
}

@XmlAccessorType(PROPERTY)
public class B extends A {
    @XmlElements( { //
    @XmlElement(name = "g", type = B.class),
        @XmlElement(name = "x", type = X.class), 
        @XmlElement(name = "y", type = Y.class), 
        @XmlElement(name = "z", type = Z.class),        
    })
    public List<XXX> getChildren() {
       return super.getChildren();
    }
}