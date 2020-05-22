class One
{
    private int i=0;
     class Two
    {
         void go()
            {
                System.out.println(new One().i);  //accessible
            }
    }
}
class two 
{
    private  int i=3;
    static class one
    {
        void go()
        {
            System.out.println(new two().i);    //accessible in static class
        }
    }
}