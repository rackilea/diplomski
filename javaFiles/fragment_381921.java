class Loan
{
    double loan;
    public String toString()
    {
        String loanstring = String.format ("%.2f", loan);
        return "Loan: " + loanstring;
    }
}
class Circle
{
    double radius;
    public String toString()
    {
        String radiusstring = String.format ("%.2f", radius);
        return "Circle: " + radiusstring;
    }
}