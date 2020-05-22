public class cn {
    public static void main(String arf[])
    {
        Scanner in =new Scanner(System.in);
        int items;
        double sum=0;
        items=in.nextInt();
        if(items<=1000)
        {
            sum=items*2.25;
            System.out.println((int)sum);
        }
        else
        {
            if(items<=3000&&items>1000)
            {sum=2250;
            items-=1000;
                sum+=items*2;
                System.out.println((int)sum);

            }
            else
            {
                if(items<=5000&&items>3000)
                {sum=6250;
                items-=3000;
                    sum+=items*1.5;
                    System.out.println((int)sum);

                }
            }
        }
    }
}