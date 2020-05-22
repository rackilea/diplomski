import java.math.BigDecimal;

    public static void main(String[] args){

        BigDecimal a = new BigDecimal(10.05);
        BigDecimal b = new BigDecimal(2.10);
        BigDecimal result;

        result = a.remainder(b);
        System.out.printf("Here we are : %s", result);

    }