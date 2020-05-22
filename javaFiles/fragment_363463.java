public enum Month 
{
    SEPTEMBER (3.33),
    OCTOBER (4.85),
    NOVEMBER (5.98),
    etc ;

    public final double Price;

    Month(double monthPrice)
    {
        this.Price = monthPrice;
    }        
}