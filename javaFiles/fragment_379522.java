final Integer[] arr =
{ 12, 67, 1, 34, 9, 78, 6, 31 };
final Integer[] perm = new Integer[arr.length];
for (int i = 0 ; i != perm.length ; i++) {
    perm[i] = i;
}
Arrays.sort(perm, new Comparator<Integer>()
{
    @Override
    public int compare(Integer x, Integer y)
    {
        return arr[x] - arr[y];
    }
});

System.out.println("low to high:" + Arrays.toString(perm));