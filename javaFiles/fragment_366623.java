public class Test {

@SuppressWarnings("unchecked")
public static void main(String[] args) throws UnsupportedEncodingException {

    Map<String, List<SimpleBean>> map = MapUtils.lazyMap(new HashMap<String,List<Object>>(),new Factory() {

        public Object create() {
            return LazyList.decorate(new ArrayList<SimpleBean>(), FactoryUtils.instantiateFactory(SimpleBean.class));
        }
    });

    System.out.println(map.get("test").get(0));
}

public static class SimpleBean {
    private String name;
}

}