public class MyChildImpAdapter extends XmlAdapter<Child, MyAbstractChild> {
    private final Class<? extends AbstractChild> implClass;

    public MyChildImpAdapter(final Class<? extends MyAbstractChild> implClass){
        this.implClass = implClass;
    }

    @Override
    public MyAbstractChild unmarshal(final Child child) throws Exception {
        if (MyChildImpl.class.equals(this.implClass)) {
            return new MyChildImpl(child);
        } else {
            return new MyChildImpl2(child);
        }
    }

    @Override
    public Child marshal(final MyAbstractChild abstractChild) throws Exception {
        return abstractChild.getChild();
    }
}