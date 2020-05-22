class Environments {
    @XmlElement(name = "Environment")
    public List<Environment> environments;
}

class Environment {
    @XmlAttribute(name = "Name")
    public String Name;
    @XmlAttribute(name = "URIPath")
    public String URIPath;
}