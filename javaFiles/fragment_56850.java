public static Long Dot2LongIP(String dottedIP) {
    String[] addrArray = dottedIP.split("\\.");        
    long num = 0;        
    for (int i=0;i<addrArray.length;i++) {            
        int power = 3-i;            
        num += ((Integer.parseInt(addrArray[i]) % 256) * Math.pow(256,power));        
    }        
    return num;    
}