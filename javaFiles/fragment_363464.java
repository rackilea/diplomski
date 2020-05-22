public class Year
{   
    public final List<Month> Months;

    public Year(List<Month> months)
    {
        Months = months;
    }
}

public class Month
{
    public final double Price;

    public Month(double price)
    {
        Price = price;
    }
}