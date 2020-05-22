public class BarDeserializer extends JsonDeserializer<Bar> {



    @Override
    public Bar deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
         JsonNode node = p.getCodec().readTree(p);
            int id = (Integer) ((IntNode) node.get("foo")).numberValue(); 
         Bar bar= new Bar();
         Foo foo=new Foo();
         foo.setId(new Long(id));
         bar.setFoo(foo);
         return bar;
    }



}


@JsonDeserialize(using=BarDeserializer.class)
public class Bar {      

     private Foo foo;

    public Foo getFoo() {
        return foo;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }




}