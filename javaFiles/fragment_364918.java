//---------------------------------------------------------------------------
int bits(DWORD p)
    {
    DWORD m=0x80000000; int b=32;
    for (;m;m>>=1,b--)
     if (p>=m) break;
    return b;
    }
//---------------------------------------------------------------------------
DWORD sqrt(const DWORD &x)
    {
    DWORD m,a;
    m=(bits(x)>>1);
    if (m) m=1<<m; else m=1;
    for (a=0;m;m>>=1) { a|=m; if (a*a>x) a^=m; }
    return a;
    }
//---------------------------------------------------------------------------
List<int> primes_i32;                   // list of precomputed primes
const int primes_map_sz=4106301;        // max size of map for speedup search for primes max(LCM(used primes per bit)) (not >>1 because SOE is periodic at double LCM size and only odd values are stored 2/2=1)
const int primes_map_N[8]={ 4106301,3905765,3585337,4026077,3386981,3460469,3340219,3974653 };
const int primes_map_i0=33;             // first index of prime not used in mask
const int primes_map_p0=137;            // biggest prime used in mask
BYTE primes_map[primes_map_sz];         // factors map for first i0-1 primes
bool primes_i32_alloc=false;
int isprime(int p)
    {
    int i,j,a,b,an,im[8]; BYTE u;
    an=0;
    if (!primes_i32.num)                // init primes vars
        {
        primes_i32.allocate(1024*1024);
        primes_i32.add(  2); for (i=1;i<primes_map_sz;i++) primes_map[i]=255; primes_map[0]=254;
        primes_i32.add(  3); for (u=255-  1,j=  3,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add(  5); for (u=255-  2,j=  5,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add(  7); for (u=255-  4,j=  7,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add( 11); for (u=255-  8,j= 11,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add( 13); for (u=255- 16,j= 13,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add( 17); for (u=255- 32,j= 17,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add( 19); for (u=255- 64,j= 19,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add( 23); for (u=255-128,j= 23,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add( 29); for (u=255-  1,j=137,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add( 31); for (u=255-  2,j=131,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add( 37); for (u=255-  4,j=127,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add( 41); for (u=255-  8,j=113,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add( 43); for (u=255- 16,j= 83,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add( 47); for (u=255- 32,j= 61,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add( 53); for (u=255- 64,j=107,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add( 59); for (u=255-128,j=101,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add( 61); for (u=255-  1,j=103,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add( 67); for (u=255-  2,j= 67,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add( 71); for (u=255-  4,j= 37,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add( 73); for (u=255-  8,j= 41,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add( 79); for (u=255- 16,j= 43,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add( 83); for (u=255- 32,j= 47,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add( 89); for (u=255- 64,j= 53,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add( 97); for (u=255-128,j= 59,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add(101); for (u=255-  1,j= 97,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add(103); for (u=255-  2,j= 89,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add(107); for (u=255-  4,j=109,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add(109); for (u=255-  8,j= 79,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add(113); for (u=255- 16,j= 73,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add(127); for (u=255- 32,j= 71,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add(131); for (u=255- 64,j= 31,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        primes_i32.add(137); for (u=255-128,j= 29,i=j>>1;i<primes_map_sz;i+=j) primes_map[i]&=u;
        }

    if (!primes_i32_alloc)
        {
        if (p  <=1) return 0;               // ignore too small walues
        if (p&1==0) return 0;               // not prime if even
        if (p>primes_map_p0)
            {
            j=p>>1;
            i=j; if (i>=primes_map_N[0]) i%=primes_map_N[0]; if (!(primes_map[i]&  1)) return 0;
            i=j; if (i>=primes_map_N[1]) i%=primes_map_N[1]; if (!(primes_map[i]&  2)) return 0;
            i=j; if (i>=primes_map_N[2]) i%=primes_map_N[2]; if (!(primes_map[i]&  4)) return 0;
            i=j; if (i>=primes_map_N[3]) i%=primes_map_N[3]; if (!(primes_map[i]&  8)) return 0;
            i=j; if (i>=primes_map_N[4]) i%=primes_map_N[4]; if (!(primes_map[i]& 16)) return 0;
            i=j; if (i>=primes_map_N[5]) i%=primes_map_N[5]; if (!(primes_map[i]& 32)) return 0;
            i=j; if (i>=primes_map_N[6]) i%=primes_map_N[6]; if (!(primes_map[i]& 64)) return 0;
            i=j; if (i>=primes_map_N[7]) i%=primes_map_N[7]; if (!(primes_map[i]&128)) return 0;
            }
        }

    an=primes_i32[primes_i32.num-1];
    if (an>=p)
        {
        // linear table search
        if (p<127)  // 31st prime
            {
            if (an>=p) for (i=0;i<primes_i32.num;i++)
                {
                a=primes_i32[i];
                if (a==p) return 1;
                if (a> p) return 0;
                }
            }
        // approximation table search
        else{
            for (j=1,i=primes_i32.num-1;j<i;j<<=1); j>>=1; if (!j) j=1;
            for (i=0;j;j>>=1)
                {
                i|=j;
                if (i>=primes_i32.num) { i-=j; continue; }
                a=primes_i32[i];
                if (a==p) return 1;
                if (a> p) i-=j;
                }
            return 0;
            }
        }
    a=an; a+=2;
    for (j=a>>1,i=0;i<8;i++) im[i]=j%primes_map_N[i];
    an=(1<<((bits(p)>>1)+1))-1; if (an<=0) an=1;
    an=an+an;
    for (;a<=p;a+=2)
        {
        for (j=1,i=0;i<8;i++,j<<=1)                     // check if map is set
         if (!(primes_map[im[i]]&j)) { j=-1; break; }   // if not dont bother with division
        for (i=0;i<8;i++) { im[i]++; if (im[i]>=primes_map_N[i]) im[i]-=primes_map_N[i]; }
        if (j<0) continue;
        for (i=primes_map_i0;i<primes_i32.num;i++)
            {
            b=primes_i32[i];
            if (b>an) break;
            if ((a%b)==0) { i=-1; break; }
            }
        if (i<0) continue;
        primes_i32.add(a);
        if (a==p) return 1;
        if (a> p) return 0;
        }
    return 0;
    }
//---------------------------------------------------------------------------
void getprimes(int p)                       // compute and allocate primes up to p
    {
    if (!primes_i32.num) isprime(3);
    int p0=primes_i32[primes_i32.num-1];    // biggest prime computed yet
    if (p>p0+10000)                         // if too big difference use sieves to fast precompute
        {
        // T((0.3516+0.5756*log10(n))*n) -> O(n.log(n))
        // sieves N/16 bytes p=100 000 000 t=1903.031 ms
        //  ------------------------------
        //   0  1  2  3  4  5  6  7 bit
        //  ------------------------------
        //   1  3  5  7  9 11 13 15 +-> +2
        //  17 19 21 23 25 27 29 31 |
        //  33 35 37 39 41 43 45 47 V +16
        //  ------------------------------
        int N=(p|15),M=(N>>4);              // store only odd values 1,3,5,7,... each bit ...
        char *m=new char[M+1];              // m[i] ->  is 1+i+i prime? (factors map)
        int i,j,k,n;
        // init sieves
        m[0]=254; for (i=1;i<=M;i++) m[i]=255;
        for(n=sqrt(p),i=1;i<=n;)
            {
            int a=m[i>>4];
            if (int(a&  1)!=0) for(k=i+i,j=i+k;j<=N;j+=k) m[j>>4]&=255-(1<<((j>>1)&7)); i+=2;
            if (int(a&  2)!=0) for(k=i+i,j=i+k;j<=N;j+=k) m[j>>4]&=255-(1<<((j>>1)&7)); i+=2;
            if (int(a&  4)!=0) for(k=i+i,j=i+k;j<=N;j+=k) m[j>>4]&=255-(1<<((j>>1)&7)); i+=2;
            if (int(a&  8)!=0) for(k=i+i,j=i+k;j<=N;j+=k) m[j>>4]&=255-(1<<((j>>1)&7)); i+=2;
            if (int(a& 16)!=0) for(k=i+i,j=i+k;j<=N;j+=k) m[j>>4]&=255-(1<<((j>>1)&7)); i+=2;
            if (int(a& 32)!=0) for(k=i+i,j=i+k;j<=N;j+=k) m[j>>4]&=255-(1<<((j>>1)&7)); i+=2;
            if (int(a& 64)!=0) for(k=i+i,j=i+k;j<=N;j+=k) m[j>>4]&=255-(1<<((j>>1)&7)); i+=2;
            if (int(a&128)!=0) for(k=i+i,j=i+k;j<=N;j+=k) m[j>>4]&=255-(1<<((j>>1)&7)); i+=2;
            }
        // compute primes
        i=p0&0xFFFFFFF1; k=m[i>>4]; // start after last found prime in list
        if ((int(k&  1)!=0)&&(i>p0)) primes_i32.add(i); i+=2;
        if ((int(k&  2)!=0)&&(i>p0)) primes_i32.add(i); i+=2;
        if ((int(k&  4)!=0)&&(i>p0)) primes_i32.add(i); i+=2;
        if ((int(k&  8)!=0)&&(i>p0)) primes_i32.add(i); i+=2;
        if ((int(k& 16)!=0)&&(i>p0)) primes_i32.add(i); i+=2;
        if ((int(k& 32)!=0)&&(i>p0)) primes_i32.add(i); i+=2;
        if ((int(k& 64)!=0)&&(i>p0)) primes_i32.add(i); i+=2;
        if ((int(k&128)!=0)&&(i>p0)) primes_i32.add(i); i+=2;
        for(j=i>>4;j<M;i+=16,j++)   // continue with 16-blocks
            {
            k=m[j];
            if (!k) continue;
            if (int(k&  1)!=0) primes_i32.add(i   );
            if (int(k&  2)!=0) primes_i32.add(i+ 2);
            if (int(k&  4)!=0) primes_i32.add(i+ 4);
            if (int(k&  8)!=0) primes_i32.add(i+ 6);
            if (int(k& 16)!=0) primes_i32.add(i+ 8);
            if (int(k& 32)!=0) primes_i32.add(i+10);
            if (int(k& 64)!=0) primes_i32.add(i+12);
            if (int(k&128)!=0) primes_i32.add(i+14);
            }
        k=m[j]; // do the last primes
        if ((int(k&  1)!=0)&&(i<=p)) primes_i32.add(i); i+=2;
        if ((int(k&  2)!=0)&&(i<=p)) primes_i32.add(i); i+=2;
        if ((int(k&  4)!=0)&&(i<=p)) primes_i32.add(i); i+=2;
        if ((int(k&  8)!=0)&&(i<=p)) primes_i32.add(i); i+=2;
        if ((int(k& 16)!=0)&&(i<=p)) primes_i32.add(i); i+=2;
        if ((int(k& 32)!=0)&&(i<=p)) primes_i32.add(i); i+=2;
        if ((int(k& 64)!=0)&&(i<=p)) primes_i32.add(i); i+=2;
        if ((int(k&128)!=0)&&(i<=p)) primes_i32.add(i); i+=2;
        delete[] m;
        }
    else{
        bool b0=primes_i32_alloc;
        primes_i32_alloc=true;
        isprime(p);
        primes_i32_alloc=false;
        primes_i32_alloc=b0;
        }
    }
//---------------------------------------------------------------------------