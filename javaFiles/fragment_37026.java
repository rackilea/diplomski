Arrays.sort(rows, new Comparator<String>()
{
    public int compare(String o1, String o2)
    {
         return Integer.parseInt(o2) - Integer.parseInt(o1);
    }
});