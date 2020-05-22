// After type erasure
public class Generic {
    private Object member;

    public Generic(Object member) {
        this.member = member;
    }

    public Object getMember() {
        return member;
    }

    public List getStringList() {
        return new ArrayList();
    }
}