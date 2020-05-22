void test(unsigned a, unsigned b)
{
  unsigned long long aa = a | ((unsigned long long)a<<32);
  while(aa>=b)
  {
    if (unsigned(aa) == b) return true;
    aa>>=1;
  }
return false;
}