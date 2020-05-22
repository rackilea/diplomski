import java.math.*; 

public class DecimalToHex{
    public String decimalToHex(String decInpString){

        StringBuilder hexOut = new StringBuilder();
        double doubleOfDecInp = Double.parseDouble(decInpString);

        if(doubleOfDecInp < 0){

            hexOut = hexOut.append("-");
            doubleOfDecInp = -doubleOfDecInp;
        }

        BigInteger beforedot = new BigDecimal(doubleOfDecInp).toBigInteger();
        hexOut.append(beforedot.toString(16));

        BigDecimal bfd =new BigDecimal(beforedot);
        doubleOfDecInp = doubleOfDecInp - bfd.doubleValue();

        if(doubleOfDecInp == 0){
            return hexOut.toString();
        }
        hexOut.append(".");

        for (int i = 0; i < 16; ++i) {
            doubleOfDecInp = doubleOfDecInp * 16;
            int digit = (int)doubleOfDecInp;

            hexOut.append(Integer.toHexString(digit));

            doubleOfDecInp = doubleOfDecInp - digit;

            if (doubleOfDecInp == 0)
                break;
        }

        return hexOut.toString();
    }

    public static void main(String args[]){

        String decimalInp = "-0.767";
        String out ; 
        DecimalToHex i = new DecimalToHex();
        out = i.decimalToHex(decimalInp);
        System.out.println(out);    

    }
}