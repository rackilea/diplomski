public class Bar {
    @JacksonXmlProperty(namespace = "name",localName="x")
    public String x = "x";
    @JacksonXmlProperty(namespace = "name",localName="y")
    public String y = "y";
} 

@JacksonXmlRootElement(namespace = "name", localName = "Foo")
public class Foo {
   private Bar bar;

   @JacksonXmlProperty(namespace = "name", localName = "Bar")
   public Bar getBar() {
      return bar;
   }

   public void setBar(Bar bar) {
      this.bar = bar;
   }
}