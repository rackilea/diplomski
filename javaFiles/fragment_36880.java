double fa=0, fb=0, fc=0;

double a=-20;
double b=a+1;

while(true)
    {
    fa=p*Math.exp(a) + q*Math.sin(a) + r*Math.cos(a) + s*Math.tan(a) + t*Math.pow(a,2) + u;
    fb=p*Math.exp(b) + q*Math.sin(b) + r*Math.cos(b) + s*Math.tan(b) + t*Math.pow(b,2) + u;

    if( (fa < 0 && fb > 0) || (fa > 0 && fb < 0) )
        break;

    a++;b++;
    }

System.out.println("a= "+a+", b= "+b);
System.out.println("f(a)= "+fa+", f(b)= "+fb);

int k=10;
double c=0.0;

while(k!=0)
    {

    c = (a+b)/2;
    fa = p*Math.exp(a) + q*Math.sin(a) + r*Math.cos(a) + s*Math.tan(a) + t*Math.pow(a,2) + u;
    fc = p*Math.exp(c) + q*Math.sin(c) + r*Math.cos(c) + s*Math.tan(c) + t*Math.pow(c,2) + u;

    // ROOT
    if (fc==0) break;

    if (fa*fc<0)
        b=c;
    else
        a=c;

    k--;
    System.out.println("a= "+a+",b= "+b+", c= "+c+" f(c)"+fc);
}
double sol =p*Math.exp(c) + q*Math.sin(c) + r*Math.cos(c) + s*Math.tan(c) + t*Math.pow(c,2) + u;
System.out.println("root="+c);