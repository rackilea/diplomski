public class Supplying {
     private static final DataConverter<String,String> b1Converter = new SubstringConverter( 5 );
     // and so on ...


     public void supplyAttributeB1() {
         elementB.setAttributeB1( b1Converter.convert( elementA.getAttributeA1() ) );
     }

}