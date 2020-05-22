public class CoordTest {

    private static String  coords = "N 39° 28.941 W 0° 23.275";

    public static void main(String[] args) {
        String[] cArray = coords.split(" ");
        String latSign = cArray[0];
        String latDegrees = cArray[1].substring(0, cArray[1].length()-1);
        String latSubdegrees = cArray[2];
        String lonSign = cArray[3];
        String lonDegrees = cArray[4].substring(0, cArray[4].length()-1);
        String lonSubdegrees = cArray[5];
        double lat = getSign(latSign) * (Integer.valueOf(latDegrees) + convertFromDegreesToDecimal(Double.valueOf(latSubdegrees)));
        double lon = getSign(lonSign) * (Integer.valueOf(lonDegrees) + convertFromDegreesToDecimal(Double.valueOf(lonSubdegrees)));
    }


    private static int getSign(String c){
        if (c.equals("N") || c.equals("E")){
            return 1;
        }
        return -1;
    }

    private static double convertFromDegreesToDecimal(Double value){
        double result = value/60d;
        return result;
    }
}