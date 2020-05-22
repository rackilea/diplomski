@XmlElementRefs({
    @XmlElementRef(name = "object", namespace = "http://www.w3.org/1999/xhtml", type = org.hisrc.w3c.xhtml.v_1_0_strict.Object.class, required = false),
    @XmlElementRef(name = "label", namespace = "http://www.w3.org/1999/xhtml", type = Label.class, required = false),
    // 28 lines skipped
    @XmlElementRef(name = "strong", namespace = "http://www.w3.org/1999/xhtml", type = Strong.class, required = false),
    @XmlElementRef(name = "abbr", namespace = "http://www.w3.org/1999/xhtml", type = Abbr.class, required = false)
})
@XmlMixed
protected List<java.lang.Object> content;