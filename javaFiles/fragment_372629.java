public class Date
{
    private int day,month,year;
    public int getYear()
    {
        return year;
    }

    public int getMonth()
    {
        return month;
    }

    public int getDay()
    {
        return day;
    }
 public Date(int day,int month,int year){
     this.day =day;
     this.month= month;
     this.year=year;
 }

    public static int[] compareTo(Date[] date)
    { 
        int i, a0, a1, a2, a3, a4;
        a0 = date[0].getYear();
        a1 = date[1].getYear();
        a2 = date[2].getYear();
        a3 = date[3].getYear();
        a4 = date[4].getYear();
        int[] list = new int[5];
        list[0] = a0;   
        list[1] = a1;
        list[2] = a2;
        list[3] = a3;
        list[4] = a4;
        int[] list2 = new int[5];
        for (i = 0; i < list2.length - 1; i++)
        {
            if (list[i] > list[i + 1])
            {
                list2[i] = 1;
            }
            if (list[i] == list[i + 1])
            {
                list2[i] = 0;
            }
            if (list[i] < list[i + 1])
            {
            list2[i] = -1;
            }
        }

        return list2;

     }
}