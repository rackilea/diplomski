public static void main(String[] args) {
    String key = "7F6D7A688019DC4CA83883F2459E6B389BE99BB63B622A97";
    String cadena = "1800990000014303181112190600048430303030303134370029030003483032001148324830303030303135320008143919751D5EB97C";


    byte[] data_for_mac = hexStringToByteArray(cadena);
    byte[] mac_key = hexStringToByteArray(key);

    // System.out.println(new String(data_for_mac)); <-- what is this????

    byte[] mac =  calculateMAC(data_for_mac,mac_key);
}