public class NameSort {

    public static void main(String[] args) {

        String [][] names={{"Jen","Eric"},
          {"Brain","Adams"},
          {"Jon","Methew"},
          {"Antino","Ronald"},
          {"Cris","Ronald"}
         };

        for(int m=0;m<names.length;m++)
        {
            for(int n=m+1;n<names.length;n++)
            {
                if(myCompare(names[m][1],names[n][1])==1)
                {
                    swap(names, names[m], names[n], m, n);
                }
                else if (myCompare(names[m][1],names[n][1])==0)
                {
                    if(myCompare(names[m][0],names[n][0])==1)
                    {
                        swap(names, names[m], names[n], m, n);
                    }
                }
            }
        }
        for (int i=0;i<names.length;i++)
        {
            System.out.println(names[i][0]+" " +names[i][1] );
        }

    }

    public static void swap(String [][] names,String[] a,String[] b,int m,int n)
    {
        names[n]=a;
        names[m]=b;
    }

    public static int myCompare(String a, String b)
    {
        int minLength= a.length()<b.length()?a.length():b.length();
        for(int i=0;i<minLength;i++)
        {
            if(a.charAt(i)>b.charAt(i))
            {
                return 1;
            }
            else if(a.charAt(i)<b.charAt(i)){
                return -1;
            }
        }
        if(a.length()>minLength)
            return 1;
        else if (b.length()> minLength )
            return -1;
        else
            return 0;
    }
}