public static void main(String[] args) {
    System.out.println(getLat("5224.09960","N"));
}

public static double getLat(String v_str, String strNS) {
    double lat = Integer.parseInt(v_str.substring(0, 2));
    double lat2 = Double.parseDouble(v_str.substring(2));
    lat += lat2 / 60;
    return strNS.equals("S") ? -lat : lat;
}