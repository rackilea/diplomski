// Fragment
#version 420 core
uniform vec2 p0=vec2(0.0,0.0);      // mouse position <-1,+1>
uniform float zoom=1.000;           // zoom [-]
uniform int  n=100;                 // iterations [-]
uniform int  sh=7;                  // fixed point accuracy [bits]
uniform int  multipass=0;           // multi pass?
in smooth vec2 p;
out vec4 col;

const int n0=1;                     // forced iterations after escape to improve precision

vec3 spectral_color(float l)        // RGB <0,1> <- lambda l <400,700> [nm]
    {
    float t;  vec3 c=vec3(0.0,0.0,0.0);
         if ((l>=400.0)&&(l<410.0)) { t=(l-400.0)/(410.0-400.0); c.r=    +(0.33*t)-(0.20*t*t); }
    else if ((l>=410.0)&&(l<475.0)) { t=(l-410.0)/(475.0-410.0); c.r=0.14         -(0.13*t*t); }
    else if ((l>=545.0)&&(l<595.0)) { t=(l-545.0)/(595.0-545.0); c.r=    +(1.98*t)-(     t*t); }
    else if ((l>=595.0)&&(l<650.0)) { t=(l-595.0)/(650.0-595.0); c.r=0.98+(0.06*t)-(0.40*t*t); }
    else if ((l>=650.0)&&(l<700.0)) { t=(l-650.0)/(700.0-650.0); c.r=0.65-(0.84*t)+(0.20*t*t); }
         if ((l>=415.0)&&(l<475.0)) { t=(l-415.0)/(475.0-415.0); c.g=             +(0.80*t*t); }
    else if ((l>=475.0)&&(l<590.0)) { t=(l-475.0)/(590.0-475.0); c.g=0.8 +(0.76*t)-(0.80*t*t); }
    else if ((l>=585.0)&&(l<639.0)) { t=(l-585.0)/(639.0-585.0); c.g=0.84-(0.84*t)           ; }
         if ((l>=400.0)&&(l<475.0)) { t=(l-400.0)/(475.0-400.0); c.b=    +(2.20*t)-(1.50*t*t); }
    else if ((l>=475.0)&&(l<560.0)) { t=(l-475.0)/(560.0-475.0); c.b=0.7 -(     t)+(0.30*t*t); }
    return c;
    }

void main()
    {
    int i,j,N;
    vec2 pp;
    float x,y,q,xx,yy,mu;
    pp=(p/zoom)-p0;         // y (-1.0, 1.0)
    pp.x-=0.5;              // x (-1.5, 0.5)
    for (x=0.0,y=0.0,xx=0.0,yy=0.0,i=0;(i<n-n0)&&(xx+yy<4.0);i++)
        {
        q=xx-yy+pp.x;
        y=(2.0*x*y)+pp.y;
        x=q;
        xx=x*x;
        yy=y*y;     
        }
    for (j=0;j<n0;j++,i++)  // 2 more iterations to diminish fraction escape error
        {
        q=xx-yy+pp.x;
        y=(2.0*x*y)+pp.y;
        x=q;
        xx=x*x;
        yy=y*y;
        }
    mu=float(i)-log(log(sqrt(xx+yy))/log(2.0));
    mu*=float(1<<sh); i=int(mu);
    N=n<<sh;
    if (i>N) i=N;
    if (i<0) i=0;

    if (multipass!=0)
        {
        // i
        float r,g,b;
        r= i     &255; r/=255.0;
        g=(i>> 8)&255; g/=255.0;
        b=(i>>16)&255; b/=255.0;
        col=vec4(r,g,b,255);
        }
    else{
        // RGB
        q=float(i)/float(N);
        q=pow(q,0.2);
        col=vec4(spectral_color(400.0+(300.0*q)),1.0);
        }
    }