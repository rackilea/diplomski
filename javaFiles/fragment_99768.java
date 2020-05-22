public class BitwiseNegation {

 public static void main(String args[]) throws Exception {
    char a = 0xff;
    char b = 0x00 ;

    System.out.printf(">>>>>a HexaDecimal: %x Decimal: %d\n", (int)a, (int)a);
    System.out.printf(">>>>>b HexaDecimal: %x Decimal: %d\n", (int)b, (int)b);

    System.out.printf(">>>>>~a HexaDecimal: %x Decimal: %d\n", ~a, ~a);
    System.out.printf(">>>>>~b HexaDecimal: %x Decimal: %d\n", ~b, ~b); 
    }

}