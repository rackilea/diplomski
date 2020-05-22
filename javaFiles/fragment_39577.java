public String multiply(String ¢) {
    int $ = 0;
    int _ = ¢.length();
    while(0<=--_)$+=(¢.charAt(_)-0x30)<<(_&01l);
    return Integer.toString($);
}