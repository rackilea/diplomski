List<Taxpayer> taxpayers =...

Collections.sort(taxpayers, new Comparator<Taxpayer>()
{
    @Override
    public int compare(Taxpayer o1, Taxpayer o2)
    {
        return o1.sum - o2.sum; // using your correct total spent here
        // or to just sort in reverse order
        // return o2.sum - o1.sum;
    }
});