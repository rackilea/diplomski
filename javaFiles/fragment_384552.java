class RaySumLast
{
    static int arr[] = {-99,1,2,3,4,5,6,7,8,9,10,5};

    static int sum()
    {
        int sum = 0;
        int index = 0;
        for (int i : arr) {
            if(index == 0) sum += i;
            else {
                if (i > arr[i-1])
                    sum += i;
            }
            index ++;

        }
        return sum;
    }
    public static void main(String[] args)
    {
        System.out.println(sum());
    }
}