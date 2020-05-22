float InvSqrt(float x){ // line 0
   float xhalf = 0.5f * x;
   int i = Float.floatToIntBits(x); // store floating-point bits in integer
   i = 0x5f3759d5 - (i >> 1); // initial guess for Newton's method
   x = Float.intBitsToFloat(i); // convert new bits into float
   x = x*(1.5f - xhalf*x*x); // One round of Newton's method
   return x;
}