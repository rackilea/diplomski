import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ChildAdapter extends XmlAdapter<ChildAdapter.AdaptedChild, Child> {

    public static class AdaptedChild {
        public Foos foos;
    }

    public static class Foos {
        public List<String> foo;
    }

    @Override
    public Child unmarshal(AdaptedChild adaptedChild) throws Exception {
        Child child = new Child();
        Foos foos = adaptedChild.foos;
        if(null != foos) {
            List<String> foo = foos.foo;
            if(null == foo) {
                child.setStrings(new ArrayList<String>());
            } else {
                child.setStrings(foos.foo);
            }
        }
        return child;
    }

    @Override
    public AdaptedChild marshal(Child child) throws Exception {
        AdaptedChild adaptedChild = new AdaptedChild();
        List<String> strings = child.getStrings();
        if(null != strings) {
            Foos foos = new Foos();
            foos.foo = strings;
            adaptedChild.foos = foos;
        }
        return adaptedChild;
    }

}