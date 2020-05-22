public class MergeSort 
{
    private int low;
    private int high;
    private int mid;
    public static int[] a;

    public MergeSort(int x)
    {
        a = new int[x];
        a[0]=19;
        a[1]=10;
        a[2]=0;
        a[3]=220;
        a[4]=80;
        a[5]=2000;
        a[6]=56001;
        a[7]=2;

    }

    public void division(int[] a)
    {
        low=0;
        int p;
        high = a.length;
        mid = (high+low)/2;
        if(a.length<2) /*Remember this is the base case*/
        {
            return;
        }
        else
        {
            int[] l = new int[mid];
            int[] r = new int[high-mid];
            /*copying elements from a into l and r*/
            for(p=0;p<mid;p++)
                l[p]=a[p];
            for(int q=0;q<high-mid;q++, p++)
                r[q]=a[p];
            /*first recursive call starts from here*/
            division(l);
            division(r); 
            sortMerge(a, l, r);
        }
    }

    public void sortMerge(int[] a, int[] l, int[] r)
    {

        int i=0, j=0, k=0;
        /*sorting and then merging recursively*/
        while(i<l.length && j<r.length)
            {
                if(l[i]<r[j])
                    {
                        a[k] = l[i]; /*copying sorted elements into a*/ 
                        i++;
                        k++;
                    }
                else
                    {
                        a[k] = r[j];
                        j++;
                        k++;
                    }
            }

        /*copying remaining elements into a*/
        while(i<l.length)
            {
                a[k] = l[i];
                i++;
                k++;
            }

        while(j<r.length)
            {
                a[k] = r[j];
                j++;
                k++;
            }

    }
    /*method display elements in an array*/
    public void display()
    {
        for(int newIndex=0;newIndex<a.length;newIndex++)
        {
        System.out.println(a[newIndex]);
        }
    }


    public static void main(String[] args) 
    {
        MergeSort obj = new MergeSort(8);
        obj.division(a);
        obj.display();
    }

}