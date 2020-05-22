/**
 * Converts a double of the form xx.yyy to xxyyy and -xx.yyy to -xxyy. 
 * No rounding is performed.
 * 
 * @param number The double to format
 * @return The formatted number string
 */
public static String format(double number){
    DecimalFormat formatter = new DecimalFormat("#");
    formatter.setRoundingMode(RoundingMode.DOWN);
    number *= number < 0.0 ? 100 : 1000;
    String result = formatter.format(number);
    return result;
}