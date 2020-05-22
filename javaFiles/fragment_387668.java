subtotal=0
iterate AL1 on index i (where i goes from zero to AL1.length()-1)
{
  iterate AL2 on index j (where j goes from zero to AL2.length()-1))
  {
    increment subtotal by AL2[AL2.length-j]*10^j * AL1[AL1.length-i]*10^i
    increment j
  }
  increment i
}