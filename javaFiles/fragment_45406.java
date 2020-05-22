import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stackoverflow52173062 {

    public static void main(final String[] args) {

        String html = "<p>​<span style=\"color: rgb(33, 150, 243);\">This is a <span style=\"background-color: rgb(255, 235, 59);\">test !!</span></span></p>";

        html = replaceRGBColorsWithHex(html);

        // final String
        System.out.println(html);
    }

    private static String replaceRGBColorsWithHex(String html) {
        // using regular expression to find all occurences of rgb(a,b,c) using
        // capturing groups to get separate numbers.
        Pattern p = Pattern.compile("(rgb\\(\\s*(\\d+)\\s*,\\s*(\\d+)\\s*,\\s*(\\d+)\\s*\\))");
        Matcher m = p.matcher(html);

        while (m.find()) {
            // get whole matched rgb(a,b,c) text
            String foundRGBColor = m.group(1);
            System.out.println("Found: " + foundRGBColor);

            // get r value
            String rString = m.group(2);
            // get g value
            String gString = m.group(3);
            // get b value
            String bString = m.group(4);

            System.out.println(" separated r value: " + rString);
            System.out.println(" separated g value: " + gString);
            System.out.println(" separated b value: " + bString);

            // converting numbers from string to int
            int rInt = Integer.parseInt(rString);
            int gInt = Integer.parseInt(gString);
            int bInt = Integer.parseInt(bString);

            // converting int to hex value
            String rHex = Integer.toHexString(rInt);
            String gHex = Integer.toHexString(gInt);
            String bHex = Integer.toHexString(bInt);

            // add leading zero if number is small to avoid converting
            // rgb(1,2,3) to rgb(#123)
            String rHexFormatted = String.format("%2s", rHex).replace(" ", "0");
            String gHexFormatted = String.format("%2s", gHex).replace(" ", "0");
            String bHexFormatted = String.format("%2s", bHex).replace(" ", "0");

            System.out.println(" converted " + rString + " to hex: " + rHexFormatted);
            System.out.println(" converted " + gString + " to hex: " + gHexFormatted);
            System.out.println(" converted " + bString + " to hex:" + bHexFormatted);

            // concatenate new color in hex
            String hexColorString = "#" + rHexFormatted + gHexFormatted + bHexFormatted ;

            System.out.println("  replacing " + foundRGBColor + " with " + hexColorString);
            html = html.replaceAll(Pattern.quote(foundRGBColor), hexColorString);
        }
        return html;
    }
}