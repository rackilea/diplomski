class llong {
    public static void main(String[] args) {
        long ip1 = 0xFF01FF80; // 255.1.255.128
        long ip2 = 0xEE28BE15; // 238.40.190.21
        System.out.println(convertHexToIp(ip1));
        System.out.println(convertHexToIp(ip2));
    }
    public static String convertHexToIp(long hex) {
        String result = "";
        result += (hex>>24 & 0xFF) + ".";
        result += (hex>>16 & 0xFF) + ".";
        result += (hex>>8 & 0xFF) + ".";
        result += (hex & 0xFF);
        return result;      
    }
}