char[] out = new char[512]; // probably best to make 512 a named constant
for( int i = 512; --i >= 0; ){
    out[i] = Character.forDigit (privexpt.intValue()&0xF, 16);
    privexpt = privexpt.shiftRight(4);
}
String result = new String (out);