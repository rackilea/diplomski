@Root(name="MyXML")
public class MyXML{
       private String a;

       @Element(name="MyElement")
       public void setMyElement(String a){
           this.a=a;
       }

       @Element(name="MyElement")
       public String getMyElement() {
          return a;           
       }
}