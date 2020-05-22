//---------------------------------------------------------------------------
int modfib0(int n,int m)
    {
    for (int i=0,x0=0,x1=1;;)
        {
        if (i>=n) return x1; x0+=x1; x0%=m; i++;
        if (i>=n) return x0; x1+=x0; x1%=m; i++;
        }
    }
//---------------------------------------------------------------------------
// matrix 2x2:  0 1
//              2 3
void modmul2x2(int *c,int *a,int *b,int m)  // c[4] = a[4]*b[4] %m
    {
    int t[4];
    t[0]=((a[0]*b[0])+(a[1]*b[2]))%m;
    t[1]=((a[0]*b[1])+(a[1]*b[3]))%m;
    t[2]=t[1]; // result is symetric so no need to compute: t[2]=((a[2]*b[0])+(a[3]*b[2]))%m;
    t[3]=((a[2]*b[1])+(a[3]*b[3]))%m;
    c[0]=t[0];
    c[1]=t[1];
    c[2]=t[2];
    c[3]=t[3];
    }
void modpow2x2(int *c,int *a,int n,int m)   // c[4] = a[4]^n %m
    {
    int t[4];
    t[0]=a[0]; c[0]=1;
    t[1]=a[1]; c[1]=0;
    t[2]=a[2]; c[2]=0;
    t[3]=a[3]; c[3]=1;
    for (;;)
        {
        if (int(n&1)!=0) modmul2x2(c,c,t,m);
        n>>=1; if (!n) break;
        modmul2x2(t,t,t,m);
        }
    }
int modfib1(int n,int m)
    {
    if (n<=0) return 0;
    int a[4]={1,1,1,0};
    modpow2x2(a,a,n,m);
    return a[0];
    }
//---------------------------------------------------------------------------