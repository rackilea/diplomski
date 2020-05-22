public class StudentRecord
{
    public int id;
    public String last;
    public String first;
    public int year;

    public StudentRecord(int d, String lt, String ft, int yr)
    {
        id=d;
        last=lt;
        first=ft;
        year=yr;
    }

    public string toString()
    {
        return id + "  " + last + "  " + first + "  " + year;
    } 
}