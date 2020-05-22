@XmlPath("PageMap/DataObject[@type='group']/Attribute[@name='name']/@value")
String groupName;

@XmlPath("PageMap/DataObject[@type='organization']/Attribute[@name='name']/@value")
@XmlAttribute(name="value")
String organization;