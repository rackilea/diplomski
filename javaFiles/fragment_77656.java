/**
 * @author Anders
 */
public class Main {

    public enum Valuta {  // here i assign the values i allow from the argument
        EUR,
        USD,
        RUB;
    }

    // here i assign the conversionrates
    static final float C_EUR_TO_DKK_RATE = (float) 7.44;

    static final float C_USD_TO_DKK_RATE = (float) 5.11;

    static final float C_RUB_TO_DKK_RATE = (float) 0.156;

    static float result = 0;

    static int value = 0;


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        if (args.length == 2) {
            value = Integer.parseInt(args[0]);
            String valutaIn = args[1]; //equalsIgnoreCase(null) boolean expression. How does this works??         


            Valuta enumConvert = Valuta.valueOf(valutaIn);

            switch (enumConvert) {

                case EUR:
                    result = value * C_EUR_TO_DKK_RATE;
                    break;

                case USD:
                    result = value * C_USD_TO_DKK_RATE;
                    break;

                case RUB:
                    result = value * C_RUB_TO_DKK_RATE;
                    break;
            }
            System.out.println((float) value + "" + enumConvert + " converts to " + (result * 100.) / 100.0 + "Dk");
        }
        else {
            System.exit(1);
        }
    }
}