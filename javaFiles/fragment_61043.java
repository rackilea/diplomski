public class Pojo {

    @JsonView({PojoViews.Response1.class, PojoViews.Response2.class, PojoViews.Response3.class})
    public String attr1;
    @JsonView({PojoViews.Response1.class, PojoViews.Response2.class, PojoViews.Response3.class})
    public int attr2;
    @JsonView({PojoViews.Response1.class, PojoViews.Response2.class})
    public double attr3;
    @JsonView(PojoViews.Response1.class)
    public boolean attr4;
}