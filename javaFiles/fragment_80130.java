@XmlRootElement(name = "container") 
static class Container {
    @XmlMixed 
    @XmlElementRefs({
            @XmlElementRef(name="foo", type=Foo.class)
    })
    List<?> content;

    // ... plus the usual getters/setters
}