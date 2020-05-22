@ManagedResource(objectName = "foo.com:name=replaced", description = "...")
public class Foo implements RuntimeJmxNames {
    ...
    public String getJmxName() {
        // here's where you can make the name be dynamic
        return toString();
    }
    @Override
    public String[] getJmxPath() {
        return new String[] { "folder" };
    }
}