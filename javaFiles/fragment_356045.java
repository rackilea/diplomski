public class Merge 
{

public static void mergesort(int arr[], int low, int high)
{
    int middle;
    if(low<high)
    {
        middle = (low+high)/2;
        mergesort(arr,low,middle);
        mergesort(arr,middle+1,high);
        merge(arr,low,middle,high);
    }
}
public static void merge(int arr[], int low, int middle, int high)
{
    Queue<Integer>half1 = new LinkedList<Integer>();
    Queue<Integer>half2 = new LinkedList<Integer>();

    for(int j = low; j<=middle;j++)
        {               
            half1.add(arr[j]);
        }
    for(int j= middle+1 ; j<=high ; j++)
        {
            half2.add(arr[j]);
        }
    int i = low;
    while(!(half1.isEmpty() || half2.isEmpty()))
    {
        if(half1.peek() <= half2.peek())
        {
            arr[i++] = half1.poll();

        }
        else {arr[i++] = half2.poll();}
    }

    while(!half1.isEmpty())
    {
        arr[i++] = half1.poll();
    }
    while(!half2.isEmpty())
    {
        arr[i++] = half2.poll();
    }
}

    public static void main (String[]args)
    {
         int arr[] = {11,45,90,121,67,19,54,28,7,50}; 
         mergesort(arr,0,arr.length-1);

         for(int a=0;a<arr.length;a++)
              System.out.println(arr[a]);
    }
 }