public class MapSerialize  {
public static interface MyInterface {
    String getSpecialInfo();

    @JsonAnyGetter
    Map<String, String> delegate();
}

@JsonSerialize(as = MyInterface.class)
public static class MyImpl extends ForwardingMap<String, String> implements MyInterface {

    private String                  specialInfo;
    private HashMap<String, String> delegate = new HashMap<String, String>();

    public Map<String, String> delegate() {
        return this.delegate;
    }

    @Override
    public String getSpecialInfo() {
        return specialInfo;
    }

    public void setSpecialInfo(String specialInfo) {
        this.specialInfo = specialInfo;
    }

    @Override
    public String put(String key, String value) {
        return delegate.put(key, value);
    }
}

public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    MyImpl objectOfMapImpl = new MyImpl();
    objectOfMapImpl.setSpecialInfo("specialInfo");
    objectOfMapImpl.put("XXX", "YYY");
    String json = mapper.writeValueAsString(objectOfMapImpl);
    System.out.println(json);
}