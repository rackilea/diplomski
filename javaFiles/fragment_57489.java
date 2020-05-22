bLength = Integer.toBinaryString(b).length();
int bfirstLength = Integer.toBinaryString(bfirst).length();
a = a-b;
quotient = quotient*2+1;
b = b/2;
if (a < bfirst) {
    quotient = quotient * (int)Math.pow(2, bLength - bfirstLength);
}