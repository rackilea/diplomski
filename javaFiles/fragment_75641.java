public void count(int[] a)
{
    //for each element in array go through if conditions.
    System.out.println("N " + "Count");
    for (int i = 0; i < a.length - 1; i++)
    {   
        if (a[i] != 0)
        {
            if (a[i] == a[i + 1])
            {
                count++;
            }
            // if the next element is different, we already counted all of the
            //   current element, so print it, then reset the count
            else
            {
                System.out.println(a[i] + " " + count);
                count = 1;
            }
        }
    }
    // we haven't processed the last element yet, so do that
    if (a[a.length-1] != 0)
        System.out.println(a[a.length-1] + " " + count);
}