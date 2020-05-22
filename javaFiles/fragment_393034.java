double sum;
double i = 0.5 , y , w, p;
for (double x = 0 ; x <= 2; x=x+i)
{
 y = Math.pow(x, 2);
 w = 4 - y;
 p = w * i;
 sum += p;
}