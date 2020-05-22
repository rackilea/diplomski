int []a = new int[]{1,2,3,4,5,6,7,8,9};
for (int i = 0 ; i < a.length; i++)
{
    int index = (int)(System.nanoTime() % a.length);
    int tmp = a[index];
    a[index] = a[i];
    a[i] = tmp;
}