public static BigDecimal CalcPoisson(double m, double u, boolean va)
{
BigDecimal answer = BigDecimal.ZERO;
if(!va)
{
    BigDecimal myOwn1 = new BigDecimal(Double.toString((Math.exp(-u)* Math.pow(u, m))));
    answer =  myOwn1.divide(fakultaet(m));
}
if(va)
{
    for(int i = 0; i < m; i++)
    {
        BigDecimal myOwn = new BigDecimal(Double.toString(Math.exp(-u)* Math.pow(u, i)));
        answer = answer.add(myOwn.divide(factorial2(i)));
    }
}

return answer;