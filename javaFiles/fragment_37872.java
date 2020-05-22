public class RemoveNode {
    public interface Projection {
    @XBDelete("/list/member[@name='{0}']")
    Projection removeMember(String name);
}

    public void main(String[] args) {
    Projection projection = new XBProjector(Flags.TO_STRING_RENDERS_XML).io.file("yourfile.xml").read(projection.class);
    System.out.println("Before:"+projection);
    System.out.println("After:"+projection.removeMember("james");
    }
}