@XmlElement(name="ID")
public int id;

@XmlElement(name="Name")
public String name;

@XmlElement(name="Status")
public String status;

@XmlElement(name="Environment")
public String environment;

@XmlElement(name="Cluster")
public String cluster;

@XmlElementWrapper(name = "SupportedLocales")
@XmlElement(name = "SupportedLocale")
public List<String> supportedLocales;