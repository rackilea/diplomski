package forum9862100;

import java.util.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ChildAdapter extends XmlAdapter<ChildAdapter.AdaptedChild, Child>{

    private List<Child> childList = new ArrayList<Child>();
    private Map<String, Child> childMap = new HashMap<String, Child>();

    public static class AdaptedChild extends Child {
        @XmlElement(name="$ref")
        public String reference;
    }

    @Override
    public AdaptedChild marshal(Child child) throws Exception {
        AdaptedChild adaptedChild = new AdaptedChild();
        if(childList.contains(child)) {
            adaptedChild.reference = child.id;
        } else {
            adaptedChild.id = child.id;
            adaptedChild.foo = child.foo;
            adaptedChild.bar = child.bar;
            childList.add(child);
        }
        return adaptedChild;
    }

    @Override
    public Child unmarshal(AdaptedChild adaptedChild) throws Exception {
        Child child = childMap.get(adaptedChild.reference);
        if(null == child) {
            child = new Child();
            child.id = adaptedChild.id;
            child.foo = adaptedChild.foo;
            child.bar = adaptedChild.bar;
            childMap.put(child.id, child);
        }
        return child;
    }

}