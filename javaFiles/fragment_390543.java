public class TestRepositoryProducts {
    public static Collection<MyBean> getDummyCollection() {
        Collection<MyBean> v = new ArrayList<MyBean>();
        MyBean b1 = new MyBean();
        b1.setState("s1");
        b1.setBranch("b1");
        // set other properties of b1
        v.add(b1);

        // more beans created and added to v
        return v;
    }