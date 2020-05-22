@XmlRootElement(name = "HEAD")
public class Head { 
    @XmlElement(name = "IDCMS") private Idcms idcms;
    @XmlElement(name = "DA") private String da;
    @XmlElement(name = "ACD") private Acd acd;
    @XmlElement(name = "TID") private String tid;
    ... getters/setters
}

public class Idcms { 
    @XmlAttribute(name = "pn") private String pn;
    @XmlAttribute(name = "vers") private String vers;
    ... getters/setters
}

public class Acd {
    @XmlAttribute(name = "MSN") private String msn;
    @XmlAttribute(name = "tail") private String tail;
    @XmlAttribute(name = "type") private String type;
    ... getters/setters
}