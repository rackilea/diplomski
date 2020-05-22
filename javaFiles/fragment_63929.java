package forum11769758;

import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MyClassAdapter extends XmlAdapter<MyClass, MyClass>{

    private int levels;
    private MyMarshallerListener marshallerListener;

    public MyClassAdapter() {
    }

    public MyClassAdapter(int levels) {
        this.levels = levels;
    }

    public Marshaller.Listener getMarshallerListener() {
        if(null == marshallerListener) {
            marshallerListener = new MyMarshallerListener();
        }
        return marshallerListener;
    }

    @Override
    public MyClass marshal(MyClass myClass) throws Exception {
        if(null == marshallerListener || marshallerListener.getLevel() < levels) {
            return myClass;
        }
        return null;
    }

    @Override
    public MyClass unmarshal(MyClass myClass) throws Exception {
        return myClass;
    }

    static class MyMarshallerListener extends Marshaller.Listener {

        private int level = 0;

        public int getLevel() {
            return level;
        }

        @Override
        public void afterMarshal(Object object) {
            if(object instanceof MyClass) {
                level--;
            }
        }

        @Override
        public void beforeMarshal(Object object) {
            if(object instanceof MyClass) {
                level++;
            }
        }

    }

}