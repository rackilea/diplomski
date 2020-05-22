public class HW_ObjectArrays 
{
    public static void main( String[] args) 
    {

        System.out.println( "Start of HW_ObjectArrays\n");
        int i;
        Date d0, d1, d2, d3, d4;
        d0 = new Date(07,12,2014);
        d1 = new Date(23,06,2013);
        d2 = new Date(12,01,2012);
        d3 = new Date(12,01,2012);
        d4 = new Date(06,04,2011);
        Date[] list = new Date[5];
        list[0] = d0;
        list[1] = d1;
        list[2] = d2;
        list[3] = d3;
        list[4] = d4;

        int[] list2 =  Date.compareTo(list);
        System.out.println("d0 and d1 :" + list2[0]);
        System.out.println("d1 and d2 :" + list2[1]);
        System.out.println("d2 and d3 :" + list2[2]);   
        System.out.println("d3 and d4 :" + list2[3]);    

    }
}