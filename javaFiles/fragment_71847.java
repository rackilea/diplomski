import javax.xml.bind.annotation.adapters.XmlAdapter;

public class AssigneeAdapter extends XmlAdapter<Assignee, Assignee> {

    @Override
    public Assignee unmarshal(Assignee v) throws Exception {
        if(v.isNull()) {
            return null;
        }
        return v;
    }

    @Override
    public Assignee marshal(Assignee v) throws Exception {
        if(null == v) {
            return new Assignee();
        }
        return v;
    }

}