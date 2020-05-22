import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

public class Test implements Runnable {

   private TestConfig config = new TestConfig();

   public Test() {
   }

   public void setConfigSomething(String something) {
      config.setSomething(something);
   }

   public TestConfig getConfig() {
      return config;
   }

   public void setConfig(TestConfig config) {
      this.config = config;
   }

   @Override
   public void run() {
      // foo
   }

   public static void main(String[] args) throws JAXBException {
      Test test = new Test();
      test.setConfigSomething("My Value");

      JAXBContext jaxbContext = JAXBContext.newInstance(TestConfig.class);

      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      jaxbMarshaller.marshal(test.getConfig(), System.out);    
   }
}

@XmlRootElement
class TestConfig {
   private String something;

   @XmlAttribute
   public String getSomething() {
      return something;
   }

   public void setSomething(String something) {
      this.something = something;
   }
}