public class XMLRead {

   public static void main(String[] args) {

      XStream xStream = new XStream();    
      xStream.registerConverter(new IntegerConverter());
   }
 }