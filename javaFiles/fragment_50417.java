public static double getLat(String v_str, String strNS) {
    double v = Double.parseDouble(v_str);
    double lat = ((long) v)/100;
    double lat2 = (v - lat * 100) / 60;
    double lat3 = lat + lat2;
    double rounded = (double)(long) (lat3 * 1000000 + 0.5) / 1000000;
    return strNS.equals("S") ? -rounded : rounded;
}