Collections.sort(computers, new Comparator<Computer>()
{
    @Override
    public int compare(Computer c0, Computer c1)
    {
        return c0.getName().compareTo(c1.getName());
    }
});