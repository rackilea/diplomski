public class GroupFeed {
    @Key
    public Date updated;
    @Key("entry")
    public List<GroupEntry> groups;
}

public class GroupEntry {
    @Key
    public String id;
    @Key("apps:property")
    public List<PropertyEntry> properties;
}

public class PropertyEntry {
    @Key("@name")
    public String name;
    @Key("@value")
    public String value;
}