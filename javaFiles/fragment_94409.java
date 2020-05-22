@Getter
@Setter
public class OuterType {

    String id;
    List<Name> name;

    @Override
    public String toString() {
        return "OuterType [id=" + id + ", stuff=" + name + "]";
    }
}