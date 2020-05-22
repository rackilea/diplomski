public String intToIp(int i) {
   return (i & 0xFF) + "." +
       ((i >> 8 ) & 0xFF) + "." +
       ((i >> 16) & 0xFF) + "." +
       ((i >> 24) & 0xFF);
}