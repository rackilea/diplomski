import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScanText1 {

    public static void main(String[] args) {
        String input = "MAC11053hrsECO20133hrsECO20233hrsANT20003hrsPSY20123hrsSYG20003hrsACG20213hrsACG20713hrsCGS21003hrsECO20133hrsECO20233hrsECO34013hrsMAC22333hrsSTA20233hrsACG31313hrsECO34113hrsFIN34033hrsMAN30253hrsMAR30233hrsBUL31303hrsGEB33753hrsMAR32033hrsACG31413hrsACG33613hrsACG44013hrsACG46513hrsACG48033hrsMAN47203hrsACG49033hrsACG49043hrsACG49703hrsENC11013hrsMAC11053hrsECO20133hrsENC11023hrsECO20233hrsACG20213hrsSPC16083hrsACG20713hrsECO34013hrsCGS21003hrsACG31313hrsFIN34033hrsMAR30233hrsECO34113hrsMAN30253hrsACG31413hrsACG33613hrsBUL31303hrsACG44013hrsGEB33753hrsMAR32033hrsACG46513hrsACG48033hrsMAN47203hrs";

        Pattern p 
            = Pattern.compile(
                "(?<courseCode>\\w{3}\\d{4})" /* courseCode: 3 word chars plus 4 digits */
                + "(?<hrs>\\d{1,2})hrs"       /* hrs: 1 or 2 digits and then "hrs" */
              );

        Matcher m = p.matcher(input);
        while (m.find()) {
            String courseCode = m.group("courseCode");
            int    hrs        = Integer.parseInt(m.group("hrs"));
            System.out.format("%s %dhrs%n", courseCode, hrs);
        }
    }

}