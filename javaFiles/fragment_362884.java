/**
 *
 * @author blj0011
 */
public class DataFrame
{

    private char id;
    private String date;
    private double total;
    private double val;

    public DataFrame(char id, String date, double total, double val)
    {
        this.id = id;
        this.date = date;
        this.total = total;
        this.val = val;
    }

    public double getVal()
    {
        return val;
    }

    public void setVal(double val)
    {
        this.val = val;
    }

    public char getId()
    {
        return id;
    }

    public void setId(char id)
    {
        this.id = id;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public double getTotal()
    {
        return total;
    }

    public void setTotal(double total)
    {
        this.total = total;
    }

    @Override
    public String toString()
    {
        return id + ", " + date + ", " + total + ", " + date + ", " + val;
    }
}